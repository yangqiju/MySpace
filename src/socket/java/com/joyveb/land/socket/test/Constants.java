package com.joyveb.land.socket.test;

import java.math.BigDecimal;

/**
 * @Date: 2011-10-28
 * @Title: 常量类
 * @Copyright: Copyright (c) 2011
 * @Company: 北京畅享互联科技有限公司
 * @Author: 李明建
 * @version: 1.0
 */
public class Constants {

	public final static String CHARSET = "UTF-8";

	/** ascii 0 */
	public final static char ASCII0 = '\0';
	/** TAB键 */
	public final static String TAB = "\t";

	/** 上传通讯数据包大小固定为400字节 */
	public final static int UPLOAD_DATA_LENGTH = 400;
	/** 返回合并通讯机数据包大小为40字节 */
	public final static int RETURN_DATA_LENGTH = 40;
	
	/** 上传通讯数据包大小固定为400字节 */
	public final static int DOWNLOAD_DATA_LENGTH = 100;

	/** 下传数据文件名 格式名称 */
	public final static String SUFFIX = "ffl";
	/** 下传数据文件名分割符 */
	public final static String DECOLLATOR = "_";
	/** 下传数据文件名前后缀分割符 */
	public final static String SEPERATE = ".";

	/** 获取新期参数文件 数据包头 */
	public final static String LOTTERY_BEGIN = "lotterybegin";
	/** 新期参数文件 文件名头 */
	public final static String LOTTERY_BEGIN_FILE_PREFIX = "par";

	/** 获取开奖公告文件 数据包头 */
	public final static String LOTTERY_KJGG = "lotterykjgg";
	/** 开奖公告文件 文件名头 */
	public final static String LOTTERY_KJGG_FILE_PREFIX = "wininfo";

	/** 获取中奖数据文件 数据包头 */
	public final static String LOTTERY_ZJSJ = "lotteryzjsj";
	/** 中奖数据文件 文件名头 */
	public final static String LOTTERY_ZJSJ_FILE_PREFIX = "windata";
	/** 中奖数据文件 文件名头 */
	public final static String LOTTERY_ZJSJ_FILE_PATH = "win_price";

	/** 兑奖时请求销售系统验证兑奖合法性 数据包头 */
	public final static String LOTTERY_VALIDENCACH = "lotteryvalidencash";

	/** 兑奖时通知 数据包头 */
	public final static String LOTTERY_ENCASH = "lotteryencash";

	/** 获取销售文件 数据包头 */
	public final static String LOTTERY_XSWJ = "lotteryxswj";
	/** 销售文件 文件名头 */
	public final static String LOTTERY_XSWJ_SELL_FILE_PREFIX = "selldata";
	/** 销售统计文件 文件名头 */
	public final static String LOTTERY_XSWJ_STAT_FILE_PREFIX = "statselldata";

	/** 获取兑奖文件 数据包头 */
	public final static String LOTTERY_DJWJ = "lotterydjwj";
	/** 兑奖文件 文件名头 */
	public final static String LOTTERY_DJWJ_ENCASH_FILE_PREFIX = "encashdata";
	/** 兑奖统计文件 文件名头 */
	public final static String LOTTERY_DJWJ_STATEN_FILE_PREFIX = "statencashdata";

	/** 销售命令 数据包头 */
	public final static String LOTTERY_TICKET = "lotteryticket";

	/** 兑奖命令 数据包头 */
	public final static String LOTTERY_SERVICEENCASH = "lotteryserviceencash";

	/** 兑奖命令 数据包头 */
	public final static String LOTTERY_QUERYMONEY = "lotteryquerymoney";

	/** 获取思乐销售系统时间命令 数据包头 */
	public final static String LOTTERY_DATETIME = "lotterydatetime";

	/** --------------通讯常量------------------------start */

	/** 兑奖 */
	public final static String ENCASH_ACTION = "encash";
	
	/** --------------单票投注标识------------------------end */

	/**
	 * 分页兑奖每页记录数
	 * */
	public final static int ENCASH_COUNT = 1000;

	/**
	 * 分页查询每页记录数
	 * */
	public final static int PAGE_SIZE = 800;

	/** * 记录状态-无效 */
	public static final Short INVALID = 0;
	/** 记录状态-有效 * */
	public static final Short ISVALID = 1;
	
	/** 奖等个数 * */
	public static final int WIN_NUMBER = 10;

	/** 大奖 */
	public final static String BIG_PRIZE = "2";// BIG_PRIZE = "2";
	/** 小奖 */
	public final static String SMALL_PRIZE = "0";// SMALL_PRIZE = "0";

	public final static String DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";

	public final static String TMPFILE_SUFFIX = "tmp";

	public final static String FIELD_SPLITTER = ",";
	
	/** 单注投注金额(分)*/
	public final static BigDecimal amountPerBet = new BigDecimal(200);
	
	public static final BigDecimal BAI = new BigDecimal("100");
	
}
