package com.ltt.demo.common.common;

/**
 * @author yxb
 * @since 2019/10/30
 */
public class Const {

    public static final String FAIL = "0";

    public static final String SUCCESS = "1";

    public static final String OA_PREFIX = "eidm:oa:";

    public static final String IMPORT_INFO_PREFIX = "eidm:import:info:";

    public static final String EXPORT_INFO_PREFIX = "eidm:export:info:";

    public static final String HANDLE_ADDRESS_LOCK = "eidm:handle:address:lock";


    public static final String LOGIN_ATTRIBUTE = "user_attribute";
    public static final String ADMIN_LOGIN_ATTRIBUTE = "admin_user_attribute";
    public static final String TERMINAL_LOGIN_ATTRIBUTE = "terminal_user_attribute";

    /**
     * 指标共用企业ID
     */
    public static final String COMMON_COMPANY_ID = "0";


    /**
     * 后台模块常量
     */
    public static class AdminConst {
        /**
         * 1.企业
         */
        public static final Integer ENTERPRIS = 1;

		public static final String ENTERPRIS_NAME = "企业";

		/**
		 * 1.机构
		 */
		public static final Integer ORGAN = 2;

		public static final String ORGAN_NAME = "机构";

		/**
		 * 指标属性可编辑
		 */
		public static final Integer CAN_EDIT = 1;
		/**
		 * 指标属性不可编辑
		 */
		public static final Integer UN_CAN_EDIT = 0;
	}
    /**
     * 企业模块常量
     */
    public static class EnterprisConst {
        /**
         * 企业名称
         */
        public static final String NAME = "企业名称";

        /**
         * 1.所属行业
         */
        public static final String INDUSTRY = "所属行业";

        /**
         * 注册地
         */
        public static final String ADDRESS = "注册地";

        public static final String NAME_CODE = "A000001";
        public static final String INDUSTRY_CODE = "A000002";
        public static final String ADDRESS_CODE = "A000003";

    }

    /**
     * 机构模块常量
     */
    public static class OrganConst {
        /**
         * 企业名称
         */
        public static final String NAME = "机构名称";

        /**
         * 所属行业
         */
        public static final String INDUSTRY = "所属行业";

        /**
         * 地址
         */
        public static final String ADDRESS = "地址";
        /**
         * 网点名称
         */
        public static final String BRANCH = "网点名称";

        public static final String NAME_CODE = "A000004";
        public static final String INDUSTRY_CODE = "A000005";
        public static final String BRANCH_CODE = "A000006";
        public static final String ADDRESS_CODE = "A000007";
    }

	/**
	 * Reids缓存常量
	 */
	public static class RedisConst {
		/**
		 * 企业行业名称
		 */
		public static final String ENTERPRIS_INDUSTRY = "token:eidmEnterprisIndusty";
		/**
		 * 机构行业名称
		 */
		public static final String ORGAN_INDUSTRY = "token:eidmOrganIndusty";
	}

}
