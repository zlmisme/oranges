package com.zlmthy.utils.log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.MessageFormat;

/**
 * 日志组件
 * @author zengliming
 * @ClassName LogUtil
 * @Description TODO
 * @date 2018/9/14 14:08
 */
public class LogUtil {

    /**
     * 单例实例
     */
    private static LogUtil logUtil;

    /**
     * 用log4j2日志来记录日志
     */
    private Logger logger;

    /**
     * 单例模式
     */
    private LogUtil(){

    }

    /**
     * 构造方法，根据日志类型来记录日志
     * @param logType 日志类型
     */
    private LogUtil(LogType logType){
        logger = LogManager.getLogger(logType.getValue());
    }

    /**
     * 获取日志实例
     * @param logType 日志类型，严格按照日志类型来划分业务
     * @return 日志实例
     */
    public static LogUtil getLog(LogType logType){
        if(logUtil ==null){
            logUtil = new LogUtil(logType);
        }
        return logUtil;
    }

    /**
     * 记录info类型的日志，一般用于输出调试信息
     * @param msg 输出格式
     * @param args 覆盖值
     */
    public void info(String msg, Object ...args){
        logger.info(formatMsg(msg, args));
    }

    /**
     * 记录error类型的日志，用于在程序出错误时排错
     * @param msg 输出格式
     * @param args 覆盖值
     */
    public void error(String msg, Object ...args){
        logger.error(formatMsg(msg, args));
    }

    /**
     * 格式化日志内容，覆盖值，输出预定的格式
     * @param msg 输出格式
     * @param args 覆盖值
     * @return 格式化后日志内容
     */
    private static String formatMsg(String msg, Object ...args){
        if(args==null || args.length==0){
            return msg;
        }
        return MessageFormat.format(msg, args);
    }
}
