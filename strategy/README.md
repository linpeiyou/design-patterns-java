# 策略模式 —— 模拟鸭子游戏
### 现状
公司做了一套模拟鸭子游戏：SimUDuck。游戏中会出现各种鸭子，一边游泳戏水，一边呱呱叫。  
此时有三个类：  
- Duck：鸭子父类
```
Duck {
	quack();	// 呱呱叫
	swim();		// 游泳
	display();	// 外观，每一种鸭子都不同
}
```
- MallardDuck：外观绿头的鸭子
- ReadheadDuck：外观红头的鸭子

### 需求
要让鸭子会飞

### 存在的问题
1. 并不是所有的鸭子都会飞
2. 鸭子的叫声有：呱呱(quack)、吱吱(squeak)  

### 错误的解决办法
办法1：在Duck中添加方法fly()，然后所有鸭子继承Duck  
办法2：抽出两个接口Flyable, Quackable，所有鸭子根据属性选择实现这两个接口与否
  
### 上述的两个办法存在的问题：
- 代码在多个子类中重复
- 很难知道所有鸭子的全部行为
- 运行时的行为不容易改变
- 改变会牵一发动全身，造成其他鸭子不想要的改变

## 解决办法：采用策略模式（Strategy Pattern）
**策略模式：策略模式定义了算法族，分别封装起来，让它们之间可以互相替换，此模式让算法的变化独立于使用算法的客户。**
![](https://github.com/linpeiyou/design-patterns-java/blob/master/strategy/image/1.jpg)

### 运行结果：
![](https://github.com/linpeiyou/design-patterns-java/blob/master/strategy/image/2.jpg)

### 三个设计原则
1. 找出应用中可能需要变化之处，把它们独立出来，不要和那些不需要变化的代码混在一起
2. 针对接口编程，而不是针对实现编程
3. 少用组合，多用继承

