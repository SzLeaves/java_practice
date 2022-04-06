package com.itranswarp.learnjava;

import java.io.UnsupportedEncodingException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Learn Java from https://www.liaoxuefeng.com/
 * 
 * @author liaoxuefeng
 */
public class Main {

	static final Log log = LogFactory.getLog(Main.class);
	/* 在实例方法中引用log:
	 * protected final Log log = LogFactory.getlog(getClass())
	 * */
	

	public static void main(String[] args) {
		log.info("Start process...");
		try {
			"".getBytes("invalidCharsetName");
		} catch (UnsupportedEncodingException e) {
			// TODO: 使用log.error(String, Throwable)打印异常
			log.error("invaild", e);
		}
		log.info("Process end.");
	}
}
