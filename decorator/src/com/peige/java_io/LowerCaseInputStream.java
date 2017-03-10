package com.peige.java_io;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;

/**
 * Java I/O流，装饰者模式（与星巴兹的demo无关）
 * 继承FilterInputStream，编写一个装饰者
 * 把输入流内的所有大写字符转换成小写
 */
public class LowerCaseInputStream extends FilterInputStream {

	public static void main(String[] args) {
		int c;
		String s = "Hello, World. My name is Peyton Lin.";
		try {
			InputStream in =
					new LowerCaseInputStream(
							new BufferedInputStream(
									new ByteArrayInputStream(s.getBytes())));
			while((c = in.read()) > 0) {
				System.out.print((char) c);
			}

			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected LowerCaseInputStream(InputStream in) {
		super(in);
	}
	
	@Override
	public int read() throws IOException {
		int c = super.read();
		return (c == -1 ? c : Character.toLowerCase((char) c));
	}
	
	@Override
	public int read(byte[] b, int off, int len) throws IOException {
		int result = super.read(b, off, len);
		for(int i = off; i < off + result; ++i) {
			b[i] = (byte) Character.toLowerCase((char) b[i]);
		}
		return result;
	}
}







