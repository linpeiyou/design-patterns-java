#观察者模式 —— 让你的对象知悉现况
###现状
你的团队刚刚签下合同，负责建立Weather公司的下一代气象站——Internet气象站

###需求
- 气象站必须建立在Weather公司专利申请的WeatherData对象上，WeatherData对象负责追踪目前的天气状况（温度、湿度、气压）
- 你的团队要建立一个应用，有**三种布告板**，分别显示：目前的状况、气象统计、简单的预报，要求实时更新
- **这是一个可扩展的气象站，要公布一组API，让其他开发人员可以写出自己的气象布告板，并插入此应用中**
![](https://github.com/linpeiyou/design-patterns-java/blob/master/observer/image/1.png)

###我们的工作
建立一个应用，利用WeatherData对象取得数据，并更新三个布告板：目前状况、气象统计、天气预报。并提供一组API，让其他开发人员可以写出自己的气象布告板。

###Weather公司的WeatherData类
```
WeatherData {
	getTemperature();		// 返回最近的气象测量数据：温度
	getHumidity();			// 返回最近的气象测量数据：湿度
	getPressure();			// 返回最近的气象测量数据：气压
	measurementsChanged();	// 一旦气象测量更新，此方法会被调用
}
```
**我们的工作是实现measurementsChanged()，好让它更新目前状况、气象统计、天气预报这三个布告板**


##根据目前已有的条件分析
- WeatherData具有getter方法，可以取得三个测量值：温度、湿度、气压
- 当新的测量数据备妥时，measurementsChanged()方法就会被调用
- 我们需要实现三个使用数据的布告板：目前状况布告板、气象统计布告板、天气预报布告板。一旦WeatherData有新的测量，布告板要实时更新
- 此系统必须可扩展，让其他开发人员建立定制的布告板，用户可以随心所欲地添加或删除任何布告板。

###一个错误的做法
```
public class WeatherData {
	
	// 实例变量声明

	public void measurementsChanged() {
		float temp = getTemperature();
		float humidity = getHumidity();
		float pressure = getPressure();
		
		currentConditionDisplay.update(temp, humidity, pressure);
		statisticsDisplay.update(temp, humidity, pressure);
		forecastDisplay.update(temp, humidity, pressure);
	}

	// 其他的WeatherData方法
}
```
这样做的坏处有：
1. 我们是针对具体实现编程，而非针对接口编程
2. 对于每个新的布告板，我们都得修改代码
3. 我们无法再运行时动态地增加（或删除）布告板
4. 我们尚未封装改变的部分


##认识观察者模式
###观察者模式定义了对象之间的一对多依赖，这样一来，当一个对象改变状态时，它的所有依赖者都会受到通知并自动更新
###生活中的例子
1. 报社的业务是出版报纸
2. 向某家报社订阅报纸，只要他们有新报纸出版，就会给你送来。只要你是他们的订户，你就会一直收到新报纸
3. 当你不想再看报纸的时候，取消订阅，他们就不会再送新报纸来
4. 只要报社还在运营，就会一直有人（或单位）向他们订阅报纸或取消订阅报纸

###出版者+订阅者=观察者模式
在软件工程中，出版者改称为“主题”（Subject），订阅者改称为“观察者”（Observer）。
![](https://github.com/linpeiyou/design-patterns-java/blob/master/observer/image/2.png)

###类图
![](https://github.com/linpeiyou/design-patterns-java/blob/master/observer/image/3.png)

###松耦合的威力
**当两个对象之间松耦合，它们依然可以交互，但是不太清楚彼此的细节。**  
**观察者模式提供了一种对象设计，让主题和观察者之间松耦合**
1. 主题只知道观察者实现了某个接口（Observer），而不需要知道具体实现类
2. 任何时候我们都可以增加新的观察者、运行时可以用新的观察者取代现有观察者、可以删除某些观察者
3. 当有新类型的观察者出现时，主题的代码无需改变
4. 可以独立地复用主题或观察者
5. 改变主体或者观察者的一方，并不会影响另一方


##气象站问题——解决办法：采用观察者（Observer Pattern）
###观察者模式：观察者模式定义了对象之间的一对多依赖，这样一来，当一个对象改变状态时，它的所有依赖者都会受到通知并自动更新
![](https://github.com/linpeiyou/design-patterns-java/blob/master/observer/image/4.png)

###接口设计
```
public interface Subject {
	void registerObserver(Observer o);
	void removeObserver(Observer o);
	void notifyObservers();
}

public interface Observer {
	void update(float temp, float humidity, float pressure);
}

public interface DisplayElement {
	void display();
}
```

##Java内置的观察者模式
java.util包内包含了最基本的Observer接口与Observable类，Observer接口与Observable类使用上更方便，因为许多功能都已经事先准备好了。你甚至可以使用推（push）或拉（pull）的方式传送数据。
####Java内置的观察者模式如何运作
1. 实现观察者接口（java.util.Observer），然后调用Observable的addObserver()方法，即可成为观察者
2. 主题（扩展java.util.Obserable）**先调用setChanged()方法**，标记状态已改变的事实。**然后调用notifyObservers()或者notifyObservers(Object arg)**
3. 观察者通过update(Observable o, Object arg)接收通知
```
setChanged() {
	changed = true;
}

notifyObservers(Object arg) {
	if(changed) {
		for every observer on the list {
			call update(this, arg)
		}
		changed = false
	}
}

notifyObservers() {
	notifyObservers(null)
}
```

###运行结果：
![](https://github.com/linpeiyou/design-patterns-java/blob/master/observer/image/5.png)

###设计原则
1. 找出应用中可能需要变化之处，把它们独立出来，不要和那些不需要变化的代码混在一起
*在观察者模式中，会改变的是主题的状态，以及观察者的数目和类型。用这个模式，你可以改变依赖于主题状态的对象，却不必改变主题。*
2. 针对接口编程，而不是针对实现编程
*主题与观察者都使用接口：观察者利用主题的接口向主题注册/取消注册等；主题利用观察者的接口通知观察者。好处：松耦合*
3. 少用组合，多用继承
*将List<Observer>组合到Subject中*
4. 为了交互对象之间的松耦合设计而努力
**松耦合的设计之所以能让我们建立有弹性的OO系统，能够应对变化，是因为对象之间的互相依赖降到了最低**

##要点
- 观察者模式定义了对象之间一对多的关系
- 主题（也就是可观察者）用一个共同的接口来更新观察者
- 观察者和可观察者之间用松耦合方式结合（loosecoupling)，可观察者不知道观察者的细节，只知道观察者实现了观察者接口
- 使用此模式时，你可从被观察者处推（pull）或拉（pull）（拉在本文章中没有实现）数据（然而， 推的方式被认为更“正确”）
- 有多个观察者时，不可以依赖特定的通知次序
- Java有多种观察者模式的实现，包括了通用的java.util.Observable
- 要注意java.util.Observable实现上所带来的一些问题
- 如果有必要的话，可以实现自己的Observable，这并不难
- Swing大量使用观察者模式，许多GUI框架也是如此

