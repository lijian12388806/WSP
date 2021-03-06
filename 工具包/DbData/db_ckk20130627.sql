USE [db_ckk]
GO
/****** Object:  Table [dbo].[WORKSTATION]    Script Date: 06/27/2013 11:34:09 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[WORKSTATION](
	[PK_WORKSTATION] [int] IDENTITY(1,1) NOT NULL,
	[FACTORYNAMECN] [varchar](50) NULL,
	[FACTORYNAMEEN] [varchar](50) NULL,
	[PHONENO] [varchar](30) NULL,
	[WSLINKMAN] [varchar](50) NULL,
	[WSEMAIL] [varchar](50) NULL,
	[WSADDR] [varchar](500) NULL,
	[REMARK] [varchar](500) NULL,
	[TEMP1] [varchar](500) NULL,
	[TEMP2] [varchar](500) NULL,
	[TEMP3] [varchar](500) NULL,
	[TEMP4] [varchar](500) NULL
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[WORKORDER]    Script Date: 06/27/2013 11:34:09 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[WORKORDER](
	[PK_WORKORDER] [int] IDENTITY(1,1) NOT NULL,
	[PK_CUSTOMERINFO] [int] NULL,
	[WORKORDERNO] [varchar](50) NULL,
	[CUSTOMERNO] [varchar](50) NULL,
	[CUSTOMERNAME] [nvarchar](100) NULL,
	[CALLERNO] [varchar](20) NULL,
	[WOSTATUS] [varchar](20) NULL,
	[ORDERTYPE] [varchar](20) NULL,
	[PROJECTTYPE] [varchar](20) NULL,
	[WORKITEM] [nvarchar](100) NULL,
	[PRONAME] [nvarchar](50) NULL,
	[PROCODE] [varchar](50) NULL,
	[ORDERSOURCE] [varchar](10) NULL,
	[GENERATEMODE] [varchar](20) NULL,
	[CALLTIME] [datetime] NULL,
	[PK_USERINFO] [int] NOT NULL,
	[DEALTIME] [datetime] NULL,
	[AUDITPERSON] [varchar](20) NULL,
	[AUDITTIME] [datetime] NULL,
	[COMPLETEPERSON] [varchar](20) NULL,
	[COMPLETETIME] [datetime] NULL,
	[REMARK] [nvarchar](500) NULL,
	[CONSULTCONTENT] [nvarchar](500) NULL,
	[NEXTACTION] [nvarchar](500) NULL,
	[REMINDFLAG] [varchar](10) NULL,
	[TEMP1] [nvarchar](500) NULL,
	[TEMP2] [nvarchar](500) NULL,
	[TEMP3] [nvarchar](500) NULL,
	[TEMP4] [nvarchar](500) NULL,
	[TEMP5] [nvarchar](500) NULL,
	[TEMP6] [nvarchar](500) NULL,
	[TEMP7] [nvarchar](500) NULL,
	[TEMP8] [nvarchar](500) NULL,
	[ACTUSERNAME] [varchar](20) NULL
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[WORKORDER] ON
SET IDENTITY_INSERT [dbo].[WORKORDER] OFF
/****** Object:  Table [dbo].[WORKINGCALENDAR]    Script Date: 06/27/2013 11:34:09 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[WORKINGCALENDAR](
	[PK_WORKINGCALENDAR] [int] IDENTITY(1,1) NOT NULL,
	[WORKINGDATE] [varchar](10) NOT NULL,
	[ISVACATION] [varchar](1) NOT NULL,
	[REAMRK] [varchar](100) NULL,
	[N1] [varchar](20) NULL,
	[N2] [varchar](20) NULL,
	[N3] [varchar](20) NULL
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[WORKINGCALENDAR] ON
SET IDENTITY_INSERT [dbo].[WORKINGCALENDAR] OFF
/****** Object:  Table [dbo].[userinfo]    Script Date: 06/27/2013 11:34:09 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[userinfo](
	[PK_USERINFO] [int] IDENTITY(1,1) NOT NULL,
	[USERNAME] [varchar](20) NULL,
	[USERPWD] [nvarchar](50) NULL,
	[ISADMIN] [varchar](10) NULL,
	[REMARK] [varchar](50) NULL,
	[PK_DEPARTMENT] [int] NULL,
	[PK_WORKSTATION] [int] NULL,
	[FACTORY] [nvarchar](50) NULL,
	[AGENTNO] [varchar](20) NULL,
	[CTIPWD] [varchar](20) NULL,
	[EXTNO] [varchar](50) NULL,
	[AGENTNAME] [varchar](50) NULL,
	[AGENTEMAIL] [varchar](50) NULL,
	[PHONENO] [varchar](50) NULL,
	[AGENTSTATUS] [varchar](50) NULL,
	[LASTLOGINTIME] [datetime] NULL,
	[AGENTTYPE] [varchar](10) NULL,
	[POSITION] [nvarchar](50) NULL,
	[USERSTATUS] [varchar](50) NULL,
	[DELFLAG] [varchar](50) NULL,
	[CTIADDR] [nvarchar](100) NULL,
	[CTIADDRBAK] [nvarchar](100) NULL,
	[AUTHADDR] [nvarchar](100) NULL,
	[AUTHTYPE] [varchar](50) NULL,
	[TEMP1] [nvarchar](100) NULL,
	[TEMP2] [nvarchar](100) NULL,
	[TEMP3] [nvarchar](100) NULL,
	[TEMP4] [nvarchar](100) NULL,
	[TEMP5] [nvarchar](100) NULL,
	[AUTOREPORT] [varchar](10) NULL
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[userinfo] ON
INSERT [dbo].[userinfo] ([PK_USERINFO], [USERNAME], [USERPWD], [ISADMIN], [REMARK], [PK_DEPARTMENT], [PK_WORKSTATION], [FACTORY], [AGENTNO], [CTIPWD], [EXTNO], [AGENTNAME], [AGENTEMAIL], [PHONENO], [AGENTSTATUS], [LASTLOGINTIME], [AGENTTYPE], [POSITION], [USERSTATUS], [DELFLAG], [CTIADDR], [CTIADDRBAK], [AUTHADDR], [AUTHTYPE], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [AUTOREPORT]) VALUES (1, N'admin', N'ywrTAw4Wmq==', N'true', N'测试', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'Y', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[userinfo] ([PK_USERINFO], [USERNAME], [USERPWD], [ISADMIN], [REMARK], [PK_DEPARTMENT], [PK_WORKSTATION], [FACTORY], [AGENTNO], [CTIPWD], [EXTNO], [AGENTNAME], [AGENTEMAIL], [PHONENO], [AGENTSTATUS], [LASTLOGINTIME], [AGENTTYPE], [POSITION], [USERSTATUS], [DELFLAG], [CTIADDR], [CTIADDRBAK], [AUTHADDR], [AUTHTYPE], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [AUTOREPORT]) VALUES (24, N'lianghe', N'mZaWmG==', N'false', N'', NULL, NULL, N'', N'1002', N'3002', N'3002', N'梁鹤', N'', N'', NULL, NULL, N'OAgent', N'', N'Y', NULL, N'172.16.5.60', N'', N'', N'Batch', N'', N'1001=1;', NULL, NULL, NULL, NULL)
INSERT [dbo].[userinfo] ([PK_USERINFO], [USERNAME], [USERPWD], [ISADMIN], [REMARK], [PK_DEPARTMENT], [PK_WORKSTATION], [FACTORY], [AGENTNO], [CTIPWD], [EXTNO], [AGENTNAME], [AGENTEMAIL], [PHONENO], [AGENTSTATUS], [LASTLOGINTIME], [AGENTTYPE], [POSITION], [USERSTATUS], [DELFLAG], [CTIADDR], [CTIADDRBAK], [AUTHADDR], [AUTHTYPE], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [AUTOREPORT]) VALUES (25, N'nick', N'mZaWmq==', N'false', N'', NULL, NULL, N'', N'1001', N'3001', N'3001', N'徐义清', N'', N'', NULL, NULL, N'OAgent', N'', N'Y', NULL, N'172.16.5.60', N'', N'', N'Batch', N'', N'1001=1;', NULL, NULL, NULL, NULL)
INSERT [dbo].[userinfo] ([PK_USERINFO], [USERNAME], [USERPWD], [ISADMIN], [REMARK], [PK_DEPARTMENT], [PK_WORKSTATION], [FACTORY], [AGENTNO], [CTIPWD], [EXTNO], [AGENTNAME], [AGENTEMAIL], [PHONENO], [AGENTSTATUS], [LASTLOGINTIME], [AGENTTYPE], [POSITION], [USERSTATUS], [DELFLAG], [CTIADDR], [CTIADDRBAK], [AUTHADDR], [AUTHTYPE], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [AUTOREPORT]) VALUES (26, N'Blair', N'mZaWmW==', N'false', N'', NULL, NULL, N'', N'1003', N'3003', N'3003', N'Blair', N'', N'', NULL, NULL, N'OAgent', N'', N'Y', NULL, N'172.16.5.60', N'', N'', N'Batch', N'', N'1001=1;', NULL, NULL, NULL, NULL)
INSERT [dbo].[userinfo] ([PK_USERINFO], [USERNAME], [USERPWD], [ISADMIN], [REMARK], [PK_DEPARTMENT], [PK_WORKSTATION], [FACTORY], [AGENTNO], [CTIPWD], [EXTNO], [AGENTNAME], [AGENTEMAIL], [PHONENO], [AGENTSTATUS], [LASTLOGINTIME], [AGENTTYPE], [POSITION], [USERSTATUS], [DELFLAG], [CTIADDR], [CTIADDRBAK], [AUTHADDR], [AUTHTYPE], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [AUTOREPORT]) VALUES (19, N'superadmin', N'C3vWzxjHzg1PBG==', N'true', N'', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'Y', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[userinfo] ([PK_USERINFO], [USERNAME], [USERPWD], [ISADMIN], [REMARK], [PK_DEPARTMENT], [PK_WORKSTATION], [FACTORY], [AGENTNO], [CTIPWD], [EXTNO], [AGENTNAME], [AGENTEMAIL], [PHONENO], [AGENTSTATUS], [LASTLOGINTIME], [AGENTTYPE], [POSITION], [USERSTATUS], [DELFLAG], [CTIADDR], [CTIADDRBAK], [AUTHADDR], [AUTHTYPE], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [AUTOREPORT]) VALUES (21, N'liuning', N'mZaWmG==', N'false', N'', NULL, NULL, N'', N'9999', N'3002', N'3002', N'刘宁', N'', N'18201697259', NULL, NULL, N'OAgent', N'', N'Y', NULL, N'172.16.5.45', N'', N'', N'Batch', N'', N'1003=1;1002=1;', NULL, NULL, NULL, NULL)
INSERT [dbo].[userinfo] ([PK_USERINFO], [USERNAME], [USERPWD], [ISADMIN], [REMARK], [PK_DEPARTMENT], [PK_WORKSTATION], [FACTORY], [AGENTNO], [CTIPWD], [EXTNO], [AGENTNAME], [AGENTEMAIL], [PHONENO], [AGENTSTATUS], [LASTLOGINTIME], [AGENTTYPE], [POSITION], [USERSTATUS], [DELFLAG], [CTIADDR], [CTIADDRBAK], [AUTHADDR], [AUTHTYPE], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [AUTOREPORT]) VALUES (22, N'weiyf', N'mZaWmW==', N'false', N'', NULL, NULL, N'', N'9998', N'1003', N'3001', N'魏英富', N'', N'', NULL, NULL, N'OAgent', N'', N'N', NULL, N'172.16.5.45', N'', N'', N'Batch', N'', N'1003=1;1002=1;', NULL, NULL, NULL, NULL)
INSERT [dbo].[userinfo] ([PK_USERINFO], [USERNAME], [USERPWD], [ISADMIN], [REMARK], [PK_DEPARTMENT], [PK_WORKSTATION], [FACTORY], [AGENTNO], [CTIPWD], [EXTNO], [AGENTNAME], [AGENTEMAIL], [PHONENO], [AGENTSTATUS], [LASTLOGINTIME], [AGENTTYPE], [POSITION], [USERSTATUS], [DELFLAG], [CTIADDR], [CTIADDRBAK], [AUTHADDR], [AUTHTYPE], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [AUTOREPORT]) VALUES (23, N'zhaoht', N'nZKWnte5', N'false', N'', NULL, NULL, N'', N'1006', N'3006', N'3006', N'赵宏涛（测试）', N'', N'', NULL, NULL, N'OAgent', N'', N'Y', NULL, N'172.16.5.60', N'', N'', N'Batch', N'', N'1001=1;', NULL, NULL, NULL, NULL)
INSERT [dbo].[userinfo] ([PK_USERINFO], [USERNAME], [USERPWD], [ISADMIN], [REMARK], [PK_DEPARTMENT], [PK_WORKSTATION], [FACTORY], [AGENTNO], [CTIPWD], [EXTNO], [AGENTNAME], [AGENTEMAIL], [PHONENO], [AGENTSTATUS], [LASTLOGINTIME], [AGENTTYPE], [POSITION], [USERSTATUS], [DELFLAG], [CTIADDR], [CTIADDRBAK], [AUTHADDR], [AUTHTYPE], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [AUTOREPORT]) VALUES (27, N'3004', N'mZaWna==', N'false', N'', NULL, NULL, N'', N'1004', N'1004', N'3004', N'高潇涵', N'', N'', NULL, NULL, N'OAgent', N'', N'Y', NULL, N'172.16.5.60', N'', N'', N'Batch', N'', N'1002=1;', NULL, NULL, NULL, NULL)
INSERT [dbo].[userinfo] ([PK_USERINFO], [USERNAME], [USERPWD], [ISADMIN], [REMARK], [PK_DEPARTMENT], [PK_WORKSTATION], [FACTORY], [AGENTNO], [CTIPWD], [EXTNO], [AGENTNAME], [AGENTEMAIL], [PHONENO], [AGENTSTATUS], [LASTLOGINTIME], [AGENTTYPE], [POSITION], [USERSTATUS], [DELFLAG], [CTIADDR], [CTIADDRBAK], [AUTHADDR], [AUTHTYPE], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [AUTOREPORT]) VALUES (28, N'3005', N'mZaWnq==', N'false', N'', NULL, NULL, N'', N'1005', N'1005', N'3005', N'孙建阳', N'', N'', NULL, NULL, N'OAgent', N'', N'Y', NULL, N'172.16.5.60', N'', N'', N'Batch', N'', N'1002=1;', NULL, NULL, NULL, NULL)
SET IDENTITY_INSERT [dbo].[userinfo] OFF
/****** Object:  Table [dbo].[uploadfile]    Script Date: 06/27/2013 11:34:09 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[uploadfile](
	[pk_upfile] [int] IDENTITY(1,1) NOT NULL,
	[filename] [varchar](50) NULL,
	[filetype] [varchar](20) NULL,
	[filepath] [varchar](100) NULL,
	[createtime] [datetime] NULL
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[TBL_IVRSTAT_YEAR]    Script Date: 06/27/2013 11:34:09 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TBL_IVRSTAT_YEAR](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[STAT_TIME] [varchar](20) NULL,
	[TIME] [varchar](20) NULL,
	[IVR_CODE] [varchar](20) NULL,
	[CALL_NUM_OUTSIDE] [decimal](32, 0) NULL,
	[CALL_NUM_INSIDE] [decimal](32, 0) NULL,
	[CALL_NUM_IVRONLY] [decimal](32, 0) NULL,
	[IVR_SERVICERATE] [decimal](32, 4) NULL,
	[IVR_SERVICE_LEN] [decimal](32, 0) NULL,
	[IVR_AVGSERVICE_LEN] [decimal](32, 0) NULL
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[TBL_IVRSTAT_MONTH]    Script Date: 06/27/2013 11:34:09 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TBL_IVRSTAT_MONTH](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[STAT_TIME] [varchar](20) NULL,
	[TIME] [varchar](20) NULL,
	[IVR_CODE] [varchar](20) NULL,
	[CALL_NUM_OUTSIDE] [decimal](32, 0) NULL,
	[CALL_NUM_INSIDE] [decimal](32, 0) NULL,
	[CALL_NUM_IVRONLY] [decimal](32, 0) NULL,
	[IVR_SERVICERATE] [decimal](32, 4) NULL,
	[IVR_SERVICE_LEN] [decimal](32, 0) NULL,
	[IVR_AVGSERVICE_LEN] [decimal](32, 0) NULL
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[TBL_IVRSTAT_DAY]    Script Date: 06/27/2013 11:34:09 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TBL_IVRSTAT_DAY](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[STAT_TIME] [varchar](20) NULL,
	[TIME] [varchar](20) NULL,
	[IVR_CODE] [varchar](20) NULL,
	[CALL_NUM_OUTSIDE] [decimal](32, 0) NULL,
	[CALL_NUM_INSIDE] [decimal](32, 0) NULL,
	[CALL_NUM_IVRONLY] [decimal](32, 0) NULL,
	[IVR_SERVICERATE] [decimal](32, 4) NULL,
	[IVR_SERVICE_LEN] [decimal](32, 0) NULL,
	[IVR_AVGSERVICE_LEN] [decimal](32, 0) NULL
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[TBL_IVRSTAT_DAY] ON
SET IDENTITY_INSERT [dbo].[TBL_IVRSTAT_DAY] OFF
/****** Object:  Table [dbo].[SKILL_CALL_LIST]    Script Date: 06/27/2013 11:34:09 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[SKILL_CALL_LIST](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[STAT_TIME] [varchar](20) NULL,
	[AGENT_ID] [varchar](40) NULL,
	[AGENT_NAME] [varchar](40) NULL,
	[SKILL_ID] [varchar](40) NULL,
	[SKILL_DESC] [varchar](60) NULL,
	[START_TIME] [varchar](50) NULL,
	[TALKING_TIME] [decimal](32, 0) NULL,
	[CALLER] [varchar](20) NULL,
	[CALLED] [varchar](20) NULL,
	[REC_PATH] [varchar](120) NULL,
	[DIRECTION] [decimal](2, 0) NULL,
	[CALLTYPE] [decimal](2, 0) NULL
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[SKILL_CALL_LIST] ON
SET IDENTITY_INSERT [dbo].[SKILL_CALL_LIST] OFF
/****** Object:  Table [dbo].[SATSCORE]    Script Date: 06/27/2013 11:34:09 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[SATSCORE](
	[PK_SATSCORE] [int] IDENTITY(1,1) NOT NULL,
	[UCID] [varchar](50) NOT NULL,
	[CALLERNO] [varchar](24) NULL,
	[AGENTID] [varchar](8) NULL,
	[EXTNO] [varchar](8) NULL,
	[SVCTIME] [varchar](24) NULL,
	[SVCPOINT] [varchar](2) NULL,
	[VDUID] [varchar](100) NULL,
	[N1] [varchar](100) NULL,
	[N2] [varchar](100) NULL,
	[N3] [varchar](100) NULL
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[SATSCORE] ON
SET IDENTITY_INSERT [dbo].[SATSCORE] OFF
/****** Object:  Table [dbo].[ORDERDEALINFO]    Script Date: 06/27/2013 11:34:09 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ORDERDEALINFO](
	[PK_ORDERDEALINFO] [int] IDENTITY(1,1) NOT NULL,
	[PK_WORKORDER] [int] NOT NULL,
	[WORKORDERNO] [varchar](50) NULL,
	[PROKEYWORD] [nvarchar](50) NULL,
	[PRODEPARTMENT] [nvarchar](20) NULL,
	[DEPDEALMAN] [nvarchar](20) NULL,
	[PRODESC] [nvarchar](500) NULL,
	[PROREASON] [nvarchar](500) NULL,
	[PROSITUATION] [nvarchar](500) NULL,
	[OCCTIME] [datetime] NULL,
	[DEALTIME] [datetime] NULL,
	[TYPEINPERSON] [nvarchar](20) NULL,
	[ASSIGNPERSON] [nvarchar](20) NULL,
	[TYPEINTIME] [datetime] NULL,
	[WOSTATUS] [varchar](20) NULL,
	[CREATETYPE] [varchar](20) NULL,
	[REMARK] [nvarchar](500) NULL,
	[TEMP1] [nvarchar](500) NULL,
	[TEMP2] [nvarchar](500) NULL,
	[TEMP3] [nvarchar](500) NULL,
	[TEMP4] [nvarchar](500) NULL,
	[TEMP5] [nvarchar](500) NULL,
	[TEMP6] [nvarchar](500) NULL
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[ORDERDEALINFO] ON
SET IDENTITY_INSERT [dbo].[ORDERDEALINFO] OFF
/****** Object:  Table [dbo].[menuinfo]    Script Date: 06/27/2013 11:34:09 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[menuinfo](
	[PK_MENU] [int] IDENTITY(1,1) NOT NULL,
	[MENUNAME] [varchar](50) NULL,
	[SUPERMENU] [int] NULL,
	[MENUSEQ] [int] NULL,
	[ISAVAILABLE] [varchar](2) NULL,
	[LINKADDRESS] [varchar](200) NULL,
	[TEMP1] [varchar](200) NULL,
	[TEMP2] [varchar](200) NULL
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[menuinfo] ON
INSERT [dbo].[menuinfo] ([PK_MENU], [MENUNAME], [SUPERMENU], [MENUSEQ], [ISAVAILABLE], [LINKADDRESS], [TEMP1], [TEMP2]) VALUES (1, N'账号及安全管理', 0, 4, N'Y', N'', N'', NULL)
INSERT [dbo].[menuinfo] ([PK_MENU], [MENUNAME], [SUPERMENU], [MENUSEQ], [ISAVAILABLE], [LINKADDRESS], [TEMP1], [TEMP2]) VALUES (2, N'基础数据', 45, 1, N'Y', N'ListBdDict.action?changeUrl=Y&pageNum=1&numPerPage=20&onduty=false', N'dictLiNav', NULL)
INSERT [dbo].[menuinfo] ([PK_MENU], [MENUNAME], [SUPERMENU], [MENUSEQ], [ISAVAILABLE], [LINKADDRESS], [TEMP1], [TEMP2]) VALUES (3, N'用户角色与权限', 1, 3, N'Y', N'ListRole.action?changeUrl=Y&pageNum=1&numPerPage=20', N'roleLiNav', NULL)
INSERT [dbo].[menuinfo] ([PK_MENU], [MENUNAME], [SUPERMENU], [MENUSEQ], [ISAVAILABLE], [LINKADDRESS], [TEMP1], [TEMP2]) VALUES (4, N'管理员账号', 46, 2, N'Y', N'ListAdminUserinfo.action?changeUrl=Y&pageNum=1&numPerPage=20', N'adminLiNav', NULL)
INSERT [dbo].[menuinfo] ([PK_MENU], [MENUNAME], [SUPERMENU], [MENUSEQ], [ISAVAILABLE], [LINKADDRESS], [TEMP1], [TEMP2]) VALUES (5, N'菜单管理', 45, 2, N'Y', N'ListMenuinfo.action?changeUrl=Y&pageNum=1&numPerPage=20', N'menuinfoLiNav', NULL)
INSERT [dbo].[menuinfo] ([PK_MENU], [MENUNAME], [SUPERMENU], [MENUSEQ], [ISAVAILABLE], [LINKADDRESS], [TEMP1], [TEMP2]) VALUES (9, N'话务平台管理', 0, 3, N'Y', N'', N'', NULL)
INSERT [dbo].[menuinfo] ([PK_MENU], [MENUNAME], [SUPERMENU], [MENUSEQ], [ISAVAILABLE], [LINKADDRESS], [TEMP1], [TEMP2]) VALUES (10, N'操作日志', 45, 1, N'Y', N'ListLogmsg.action?changeUrl=Y&pageNum=1&numPerPage=20', N'logmsgLiNav', NULL)
INSERT [dbo].[menuinfo] ([PK_MENU], [MENUNAME], [SUPERMENU], [MENUSEQ], [ISAVAILABLE], [LINKADDRESS], [TEMP1], [TEMP2]) VALUES (22, N'工单管理', 0, 2, N'Y', N'', N'', NULL)
INSERT [dbo].[menuinfo] ([PK_MENU], [MENUNAME], [SUPERMENU], [MENUSEQ], [ISAVAILABLE], [LINKADDRESS], [TEMP1], [TEMP2]) VALUES (23, N'工单办理', 22, 1, N'Y', N'ListWorkorder.action?orderCode=wcl&pageCode=wcl&pageCode=wcl&changeUrl=Y&pageNum=1&numPerPage=20', N'workorderwclLiNav', NULL)
INSERT [dbo].[menuinfo] ([PK_MENU], [MENUNAME], [SUPERMENU], [MENUSEQ], [ISAVAILABLE], [LINKADDRESS], [TEMP1], [TEMP2]) VALUES (24, N'后续处理工单', 22, 2, N'Y', N'ListWorkorder.action?orderCode=dhxcl&pageCode=dhxcl&changeUrl=Y&pageNum=1&numPerPage=20', N'workorderdhxclLiNav', NULL)
INSERT [dbo].[menuinfo] ([PK_MENU], [MENUNAME], [SUPERMENU], [MENUSEQ], [ISAVAILABLE], [LINKADDRESS], [TEMP1], [TEMP2]) VALUES (29, N'工厂信息管理', 44, 7, N'Y', N'ListWorkstation.action?changeUrl=Y&pageNum=1&numPerPage=20', N'workstationLiNav', NULL)
INSERT [dbo].[menuinfo] ([PK_MENU], [MENUNAME], [SUPERMENU], [MENUSEQ], [ISAVAILABLE], [LINKADDRESS], [TEMP1], [TEMP2]) VALUES (31, N'IVR留言调听', 9, 1, N'Y', N'ListIvrvoice.action?changeUrl=Y&pageNum=1&numPerPage=20', N'ivrvoiceLiNav', NULL)
INSERT [dbo].[menuinfo] ([PK_MENU], [MENUNAME], [SUPERMENU], [MENUSEQ], [ISAVAILABLE], [LINKADDRESS], [TEMP1], [TEMP2]) VALUES (32, N'呼叫记录', 9, 2, N'Y', N'ListCalldetail.action?changeUrl=Y&pageNum=1&numPerPage=20', N'calldetailLiNav', NULL)
INSERT [dbo].[menuinfo] ([PK_MENU], [MENUNAME], [SUPERMENU], [MENUSEQ], [ISAVAILABLE], [LINKADDRESS], [TEMP1], [TEMP2]) VALUES (33, N'客户电话号码', 1, 8, N'N', N'ListCusphonelist.action?changeUrl=Y&pageNum=1&numPerPage=20', N'cusphonelistLiNav', NULL)
INSERT [dbo].[menuinfo] ([PK_MENU], [MENUNAME], [SUPERMENU], [MENUSEQ], [ISAVAILABLE], [LINKADDRESS], [TEMP1], [TEMP2]) VALUES (34, N'满意度调查', 9, 5, N'Y', N'ListSatscore.action?changeUrl=Y&pageNum=1&numPerPage=20', N'satscoreLiNav', NULL)
INSERT [dbo].[menuinfo] ([PK_MENU], [MENUNAME], [SUPERMENU], [MENUSEQ], [ISAVAILABLE], [LINKADDRESS], [TEMP1], [TEMP2]) VALUES (37, N'工单报表', 0, 4, N'Y', N'', N'', NULL)
INSERT [dbo].[menuinfo] ([PK_MENU], [MENUNAME], [SUPERMENU], [MENUSEQ], [ISAVAILABLE], [LINKADDRESS], [TEMP1], [TEMP2]) VALUES (38, N'待办工单统计年报', 37, 1, N'Y', N'listYearWclwo.action?fileName=wcl_year_statements.xls&changeUrl=Y&pageNum=1&numPerPage=20', N'yearWclwoLiNav', NULL)
INSERT [dbo].[menuinfo] ([PK_MENU], [MENUNAME], [SUPERMENU], [MENUSEQ], [ISAVAILABLE], [LINKADDRESS], [TEMP1], [TEMP2]) VALUES (39, N'工单分类汇总年报', 37, 4, N'Y', N'listYearStwo.action?fileName=st_year_statements.xls&changeUrl=Y&pageNum=1&numPerPage=20 ', N'yearstwoLiNav', NULL)
INSERT [dbo].[menuinfo] ([PK_MENU], [MENUNAME], [SUPERMENU], [MENUSEQ], [ISAVAILABLE], [LINKADDRESS], [TEMP1], [TEMP2]) VALUES (40, N'待办工单统计月报', 37, 2, N'Y', N'listMonthWclwo.action?fileName=wcl_month_statements.xls&changeUrl=Y&pageNum=1&numPerPage=20', N'monthWclwoLiNav', NULL)
INSERT [dbo].[menuinfo] ([PK_MENU], [MENUNAME], [SUPERMENU], [MENUSEQ], [ISAVAILABLE], [LINKADDRESS], [TEMP1], [TEMP2]) VALUES (41, N'待办工单统计日报', 37, 3, N'Y', N'listDayWclwo.action?fileName=wcl_day_statements.xls&changeUrl=Y&pageNum=1&numPerPage=20 ', N'dayWclwoLiNav', NULL)
INSERT [dbo].[menuinfo] ([PK_MENU], [MENUNAME], [SUPERMENU], [MENUSEQ], [ISAVAILABLE], [LINKADDRESS], [TEMP1], [TEMP2]) VALUES (42, N'工单分类汇总月报', 37, 5, N'Y', N'listMonthStwo.action?fileName=st_month_statements.xls&changeUrl=Y&pageNum=1&numPerPage=20 ', N'monthstwoLiNav', NULL)
INSERT [dbo].[menuinfo] ([PK_MENU], [MENUNAME], [SUPERMENU], [MENUSEQ], [ISAVAILABLE], [LINKADDRESS], [TEMP1], [TEMP2]) VALUES (43, N'工单分类汇总日报', 37, 6, N'Y', N'listDayStwo.action?fileName=st_day_statements.xls&changeUrl=Y&pageNum=1&numPerPage=20 ', N'daystwoLiNav', NULL)
INSERT [dbo].[menuinfo] ([PK_MENU], [MENUNAME], [SUPERMENU], [MENUSEQ], [ISAVAILABLE], [LINKADDRESS], [TEMP1], [TEMP2]) VALUES (45, N'系统管理', 0, 6, N'Y', N'', N'', NULL)
INSERT [dbo].[menuinfo] ([PK_MENU], [MENUNAME], [SUPERMENU], [MENUSEQ], [ISAVAILABLE], [LINKADDRESS], [TEMP1], [TEMP2]) VALUES (46, N'系统设置', 0, 7, N'Y', N'', N'', NULL)
INSERT [dbo].[menuinfo] ([PK_MENU], [MENUNAME], [SUPERMENU], [MENUSEQ], [ISAVAILABLE], [LINKADDRESS], [TEMP1], [TEMP2]) VALUES (48, N'工单量和结单率统计', 37, 7, N'Y', N'ListWorkratioReport.action?changeUrl=Y&pageNum=1&numPerPage=20', N'', NULL)
INSERT [dbo].[menuinfo] ([PK_MENU], [MENUNAME], [SUPERMENU], [MENUSEQ], [ISAVAILABLE], [LINKADDRESS], [TEMP1], [TEMP2]) VALUES (49, N'技能组指标统计日报', 37, 8, N'Y', N'listDskillstat.action?fileName=skill_day_report.xls&changeUrl=Y&pageNum=1&numPerPage=20', N'dskillstatLiNav', NULL)
INSERT [dbo].[menuinfo] ([PK_MENU], [MENUNAME], [SUPERMENU], [MENUSEQ], [ISAVAILABLE], [LINKADDRESS], [TEMP1], [TEMP2]) VALUES (51, N'IVR话务量统计日报', 60, 10, N'Y', N'listTblIvrstatDay.action?ivrtimeflag=day&fileName=tbl_ivr_day.xls&changeUrl=Y&pageNum=1&numPerPage=20', N'tblIvrstatLiNav', NULL)
INSERT [dbo].[menuinfo] ([PK_MENU], [MENUNAME], [SUPERMENU], [MENUSEQ], [ISAVAILABLE], [LINKADDRESS], [TEMP1], [TEMP2]) VALUES (52, N'IVR话务量统计月报', 60, 11, N'Y', N'listTblIvrstatMonth.action?ivrtimeflag=month&fileName=tbl_ivr_month.xls&changeUrl=Y&pageNum=1&numPerPage=20', N'tblIvrstatLiNav', NULL)
INSERT [dbo].[menuinfo] ([PK_MENU], [MENUNAME], [SUPERMENU], [MENUSEQ], [ISAVAILABLE], [LINKADDRESS], [TEMP1], [TEMP2]) VALUES (53, N'IVR话务量统计年报', 60, 12, N'Y', N'listTblIvrstatYear.action?ivrtimeflag=year&fileName=tbl_ivr_year.xls&changeUrl=Y&pageNum=1&numPerPage=20', N'tblIvrstatLiNav', NULL)
INSERT [dbo].[menuinfo] ([PK_MENU], [MENUNAME], [SUPERMENU], [MENUSEQ], [ISAVAILABLE], [LINKADDRESS], [TEMP1], [TEMP2]) VALUES (54, N'人工话务量统计日报', 60, 13, N'Y', N'listMcsDay.action?mcstimeflag=day&fileName=mcs_day.xls&changeUrl=Y&pageNum=1&numPerPage=20', N'mcsLiNav', NULL)
INSERT [dbo].[menuinfo] ([PK_MENU], [MENUNAME], [SUPERMENU], [MENUSEQ], [ISAVAILABLE], [LINKADDRESS], [TEMP1], [TEMP2]) VALUES (55, N'人工话务量统计月报', 60, 14, N'Y', N'listMcsMonth.action?mcstimeflag=month&fileName=mcs_month.xls&changeUrl=Y&pageNum=1&numPerPage=20', N'mcsLiNav', NULL)
INSERT [dbo].[menuinfo] ([PK_MENU], [MENUNAME], [SUPERMENU], [MENUSEQ], [ISAVAILABLE], [LINKADDRESS], [TEMP1], [TEMP2]) VALUES (56, N'人工话务量统计年报', 60, 15, N'Y', N'listMcsYear.action?mcstimeflag=year&fileName=mcs_year.xls&changeUrl=Y&pageNum=1&numPerPage=20', N'mcsLiNav', NULL)
INSERT [dbo].[menuinfo] ([PK_MENU], [MENUNAME], [SUPERMENU], [MENUSEQ], [ISAVAILABLE], [LINKADDRESS], [TEMP1], [TEMP2]) VALUES (58, N'坐席KPI技能分组统计月报', 60, 17, N'Y', N'listAgentKpiMonth.action?akpitimeflag=month&fileName=agent_kpi_month.xls&changeUrl=Y&pageNum=1&numPerPage=20', N'agentKpiLiNav', NULL)
INSERT [dbo].[menuinfo] ([PK_MENU], [MENUNAME], [SUPERMENU], [MENUSEQ], [ISAVAILABLE], [LINKADDRESS], [TEMP1], [TEMP2]) VALUES (60, N'IPCC报表', 0, 5, N'Y', N'', N'', NULL)
INSERT [dbo].[menuinfo] ([PK_MENU], [MENUNAME], [SUPERMENU], [MENUSEQ], [ISAVAILABLE], [LINKADDRESS], [TEMP1], [TEMP2]) VALUES (61, N'坐席话务明细', 60, 25, N'Y', N'listAgentCallList.action?fileName=agent_call_list.xls&changeUrl=Y&pageNum=1&numPerPage=20', N'aclLiNav', NULL)
INSERT [dbo].[menuinfo] ([PK_MENU], [MENUNAME], [SUPERMENU], [MENUSEQ], [ISAVAILABLE], [LINKADDRESS], [TEMP1], [TEMP2]) VALUES (62, N'技能组话务明细', 60, 26, N'Y', N'listSkillCallList.action?fileName=skill_call_list.xls&changeUrl=Y&pageNum=1&numPerPage=20', N'sclLiNav', NULL)
INSERT [dbo].[menuinfo] ([PK_MENU], [MENUNAME], [SUPERMENU], [MENUSEQ], [ISAVAILABLE], [LINKADDRESS], [TEMP1], [TEMP2]) VALUES (63, N'外呼话务量统计日报', 60, 22, N'Y', N'listCosDay.action?costimeflag=day&fileName=call_out_day.xls&changeUrl=Y&pageNum=1&numPerPage=20', N'cosLiNav', NULL)
INSERT [dbo].[menuinfo] ([PK_MENU], [MENUNAME], [SUPERMENU], [MENUSEQ], [ISAVAILABLE], [LINKADDRESS], [TEMP1], [TEMP2]) VALUES (64, N'外呼话务量统计月报', 60, 23, N'Y', N'listCosMonth.action?costimeflag=month&fileName=call_out_month.xls&changeUrl=Y&pageNum=1&numPerPage=20', N'cosLiNav', NULL)
INSERT [dbo].[menuinfo] ([PK_MENU], [MENUNAME], [SUPERMENU], [MENUSEQ], [ISAVAILABLE], [LINKADDRESS], [TEMP1], [TEMP2]) VALUES (25, N'客户信息管理', 44, 5, N'Y', N'ListCustomerinfo.action?changeUrl=Y&pageNum=1&numPerPage=20', N'customerLiNav', NULL)
INSERT [dbo].[menuinfo] ([PK_MENU], [MENUNAME], [SUPERMENU], [MENUSEQ], [ISAVAILABLE], [LINKADDRESS], [TEMP1], [TEMP2]) VALUES (26, N'工单查询', 22, 4, N'Y', N'ListWorkorder.action?orderCode=all&pageCode=all&changeUrl=Y&pageNum=1&numPerPage=20', N'workorderallLiNav', NULL)
INSERT [dbo].[menuinfo] ([PK_MENU], [MENUNAME], [SUPERMENU], [MENUSEQ], [ISAVAILABLE], [LINKADDRESS], [TEMP1], [TEMP2]) VALUES (28, N'用户账号', 1, 1, N'Y', N'ListUserinfo.action?changeUrl=Y&pageNum=1&numPerPage=20', N'userinfoLiNav', NULL)
INSERT [dbo].[menuinfo] ([PK_MENU], [MENUNAME], [SUPERMENU], [MENUSEQ], [ISAVAILABLE], [LINKADDRESS], [TEMP1], [TEMP2]) VALUES (30, N'工单结单', 22, 3, N'Y', N'ListWorkorder.action?orderCode=ywc&pageCode=ywc&changeUrl=Y&pageNum=1&numPerPage=20', N'workorderywcLiNav', NULL)
INSERT [dbo].[menuinfo] ([PK_MENU], [MENUNAME], [SUPERMENU], [MENUSEQ], [ISAVAILABLE], [LINKADDRESS], [TEMP1], [TEMP2]) VALUES (65, N'外呼话务量统计年报', 60, 24, N'Y', N'listCosYear.action?costimeflag=year&fileName=call_out_year.xls&changeUrl=Y&pageNum=1&numPerPage=20', N'cosLiNav', NULL)
INSERT [dbo].[menuinfo] ([PK_MENU], [MENUNAME], [SUPERMENU], [MENUSEQ], [ISAVAILABLE], [LINKADDRESS], [TEMP1], [TEMP2]) VALUES (35, N'定时任务', 45, 3, N'Y', N'ListJobmsg.action?changeUrl=Y&pageNum=1&numPerPage=20', N'jobmsgLiNav', NULL)
INSERT [dbo].[menuinfo] ([PK_MENU], [MENUNAME], [SUPERMENU], [MENUSEQ], [ISAVAILABLE], [LINKADDRESS], [TEMP1], [TEMP2]) VALUES (50, N'技能组指标统计时报', 37, 9, N'Y', N'listHskillstat.action?fileName=skill_hour_report.xls&changeUrl=Y&pageNum=1&numPerPage=20', N'hskillstatLiNav', NULL)
INSERT [dbo].[menuinfo] ([PK_MENU], [MENUNAME], [SUPERMENU], [MENUSEQ], [ISAVAILABLE], [LINKADDRESS], [TEMP1], [TEMP2]) VALUES (44, N'信息管理', 0, 1, N'Y', N'', N'', NULL)
INSERT [dbo].[menuinfo] ([PK_MENU], [MENUNAME], [SUPERMENU], [MENUSEQ], [ISAVAILABLE], [LINKADDRESS], [TEMP1], [TEMP2]) VALUES (47, N'工作日历', 9, 6, N'Y', N'listWorkingcalendar.action?changeUrl=Y&pageNum=1&numPerPage=20', N'workingcalendarLiNav', NULL)
INSERT [dbo].[menuinfo] ([PK_MENU], [MENUNAME], [SUPERMENU], [MENUSEQ], [ISAVAILABLE], [LINKADDRESS], [TEMP1], [TEMP2]) VALUES (57, N'坐席KPI技能分组统计日报', 60, 16, N'Y', N'listAgentKpiDay.action?akpitimeflag=day&fileName=agent_kpi_day.xls&changeUrl=Y&pageNum=1&numPerPage=20', N'agentKpiLiNav', NULL)
INSERT [dbo].[menuinfo] ([PK_MENU], [MENUNAME], [SUPERMENU], [MENUSEQ], [ISAVAILABLE], [LINKADDRESS], [TEMP1], [TEMP2]) VALUES (59, N'坐席KPI技能分组统计年报', 60, 18, N'Y', N'listAgentKpiYear.action?akpitimeflag=year&fileName=agent_kpi_year.xls&changeUrl=Y&pageNum=1&numPerPage=20', N'agentKpiLiNav', NULL)
INSERT [dbo].[menuinfo] ([PK_MENU], [MENUNAME], [SUPERMENU], [MENUSEQ], [ISAVAILABLE], [LINKADDRESS], [TEMP1], [TEMP2]) VALUES (66, N'值班管理', 45, 5, N'Y', N'ListBdDuty.action?changeUrl=Y&pageNum=1&numPerPage=20&onduty=true', N'dutyLiNav', NULL)
SET IDENTITY_INSERT [dbo].[menuinfo] OFF
/****** Object:  Table [dbo].[MANUAL_CALLINFO_STAT_YEAR]    Script Date: 06/27/2013 11:34:09 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[MANUAL_CALLINFO_STAT_YEAR](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[SKILL_ID] [varchar](40) NULL,
	[SKILL_DESC] [varchar](60) NULL,
	[STAT_TIME] [varchar](20) NULL,
	[TIME] [varchar](20) NULL,
	[IVR_TRANSF_NUM] [decimal](32, 0) NULL,
	[IVR_TRANSF_RATE] [decimal](32, 4) NULL,
	[IVR_TRANSF_FAILED] [decimal](32, 0) NULL,
	[ANSWER_NUM] [decimal](32, 0) NULL,
	[ANSWER_RATE] [decimal](32, 4) NULL,
	[ANSWERIN20_RATE] [decimal](32, 4) NULL,
	[AVGSUCC_WAIT_TIME] [decimal](32, 0) NULL,
	[AVGFAIL_WAITE_TIME] [decimal](32, 0) NULL,
	[AVG_TALKING_TIME] [decimal](32, 0) NULL
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[MANUAL_CALLINFO_STAT_MONTH]    Script Date: 06/27/2013 11:34:09 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[MANUAL_CALLINFO_STAT_MONTH](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[SKILL_ID] [varchar](40) NULL,
	[SKILL_DESC] [varchar](60) NULL,
	[STAT_TIME] [varchar](20) NULL,
	[TIME] [varchar](20) NULL,
	[IVR_TRANSF_NUM] [decimal](32, 0) NULL,
	[IVR_TRANSF_RATE] [decimal](32, 4) NULL,
	[IVR_TRANSF_FAILED] [decimal](32, 0) NULL,
	[ANSWER_NUM] [decimal](32, 0) NULL,
	[ANSWER_RATE] [decimal](32, 4) NULL,
	[ANSWERIN20_RATE] [decimal](32, 4) NULL,
	[AVGSUCC_WAIT_TIME] [decimal](32, 0) NULL,
	[AVGFAIL_WAITE_TIME] [decimal](32, 0) NULL,
	[AVG_TALKING_TIME] [decimal](32, 0) NULL
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[MANUAL_CALLINFO_STAT_DAY]    Script Date: 06/27/2013 11:34:09 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[MANUAL_CALLINFO_STAT_DAY](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[SKILL_ID] [varchar](40) NULL,
	[SKILL_DESC] [varchar](60) NULL,
	[STAT_TIME] [varchar](20) NULL,
	[TIME] [varchar](20) NULL,
	[IVR_TRANSF_NUM] [decimal](32, 0) NULL,
	[IVR_TRANSF_RATE] [decimal](32, 4) NULL,
	[IVR_TRANSF_FAILED] [decimal](32, 0) NULL,
	[ANSWER_NUM] [decimal](32, 0) NULL,
	[ANSWER_RATE] [decimal](32, 4) NULL,
	[ANSWERIN20_RATE] [decimal](32, 4) NULL,
	[AVGSUCC_WAIT_TIME] [decimal](32, 0) NULL,
	[AVGFAIL_WAITE_TIME] [decimal](32, 0) NULL,
	[AVG_TALKING_TIME] [decimal](32, 0) NULL
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[MANUAL_CALLINFO_STAT_DAY] ON
SET IDENTITY_INSERT [dbo].[MANUAL_CALLINFO_STAT_DAY] OFF
/****** Object:  Table [dbo].[logmsg]    Script Date: 06/27/2013 11:34:09 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[logmsg](
	[pk_logmsg] [int] IDENTITY(1,1) NOT NULL,
	[username] [varchar](50) NULL,
	[createtime] [datetime] NULL,
	[ip] [varchar](30) NULL,
	[logtype] [varchar](30) NULL,
	[logcontent] [varchar](2048) NULL,
	[entityname] [varchar](200) NULL
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[IVRVOICE]    Script Date: 06/27/2013 11:34:09 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[IVRVOICE](
	[PK_IVRVOICE] [int] IDENTITY(1,1) NOT NULL,
	[LEAVEWORDNUM] [varchar](50) NULL,
	[SERVERIP] [varchar](50) NULL,
	[CALLERID] [varchar](50) NULL,
	[STARTTIME] [varchar](24) NULL,
	[ENDTIME] [varchar](24) NULL,
	[STARTDATE] [varchar](24) NULL,
	[ENDDATE] [varchar](24) NULL,
	[FILENAME] [varchar](255) NULL,
	[ISNOTICE] [varchar](1) NULL,
	[ISCHECK] [varchar](1) NULL,
	[DNIS] [varchar](24) NULL,
	[CREATE_DATE] [varchar](24) NULL,
	[PROCESSRESULT] [varchar](255) NULL,
	[UCID] [varchar](100) NULL,
	[VDUID] [varchar](100) NULL,
	[N1] [varchar](100) NULL,
	[N2] [varchar](100) NULL,
	[N3] [varchar](100) NULL,
	[FULLSTARTDATE] [varchar](24) NULL,
	[FULLENDDATE] [varchar](24) NULL,
 CONSTRAINT [PK_IVRVOICE] PRIMARY KEY CLUSTERED 
(
	[PK_IVRVOICE] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[IVRVOICE] ON
SET IDENTITY_INSERT [dbo].[IVRVOICE] OFF
/****** Object:  Table [dbo].[HSKILLSTAT]    Script Date: 06/27/2013 11:34:09 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[HSKILLSTAT](
	[ID] [int] NOT NULL,
	[STATDATE] [varchar](20) NULL,
	[Intrahour] [int] NULL,
	[SKILL_ID] [varchar](20) NULL,
	[SKILL_DESC] [varchar](60) NULL,
	[CALL_NUM] [decimal](32, 0) NULL,
	[SUCCESS_NUM] [decimal](32, 0) NULL,
	[FAILED_NUM] [decimal](32, 0) NULL,
	[SUCCESSIN20_NUM] [decimal](32, 0) NULL,
	[F_WAIT_TIME] [decimal](32, 0) NULL,
	[S_WAIT_TIME] [decimal](32, 0) NULL,
	[TAIKING_TIME] [decimal](32, 0) NULL
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[DSKILLSTAT]    Script Date: 06/27/2013 11:34:09 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[DSKILLSTAT](
	[ID] [int] NOT NULL,
	[STATDATE] [varchar](20) NULL,
	[SKILL_ID] [varchar](20) NULL,
	[SKILL_DESC] [varchar](60) NULL,
	[CALL_NUM] [decimal](32, 0) NULL,
	[SUCCESS_NUM] [decimal](32, 0) NULL,
	[FAILED_NUM] [decimal](32, 0) NULL,
	[SUCCESSIN20_NUM] [decimal](32, 0) NULL,
	[F_WAIT_TIME] [decimal](32, 0) NULL,
	[S_WAIT_TIME] [decimal](32, 0) NULL,
	[TAIKING_TIME] [decimal](32, 0) NULL
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[DEPARTMENT]    Script Date: 06/27/2013 11:34:09 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[DEPARTMENT](
	[PK_DEPARTMENT] [int] IDENTITY(1,1) NOT NULL,
	[SPK_DEPARTMENT] [int] NULL,
	[DEPNAME] [varchar](50) NULL,
	[REMARK] [nvarchar](500) NULL,
	[TEMP1] [nvarchar](500) NULL,
	[TEMP2] [nvarchar](500) NULL,
	[TEMP3] [nvarchar](500) NULL,
	[TEMP4] [nvarchar](500) NULL
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[CUSTOMERINFO]    Script Date: 06/27/2013 11:34:09 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[CUSTOMERINFO](
	[PK_CUSTOMERINFO] [int] IDENTITY(1,1) NOT NULL,
	[CUSTOMERNO] [varchar](30) NULL,
	[CUSTOMERNAME] [nvarchar](100) NULL,
	[CUSTLINKMAN] [nvarchar](100) NULL,
	[CUSTPHONENO] [varchar](2000) NULL,
	[POSTCODE] [varchar](10) NULL,
	[EMAILADDR] [varchar](100) NULL,
	[NETHERLANDS] [varchar](50) NULL,
	[CUSTTYPE] [varchar](10) NULL,
	[CUSTLEVEL] [varchar](10) NULL,
	[CUSTSTATUS] [varchar](10) NULL,
	[PROVINCE] [varchar](20) NULL,
	[CITY] [varchar](20) NULL,
	[CUSTADDR] [nvarchar](200) NULL,
	[INFOSOURCE] [varchar](10) NULL,
	[UPDATETIME] [datetime] NULL,
	[REMARK] [nvarchar](500) NULL,
	[TEMP1] [nvarchar](500) NULL,
	[TEMP2] [nvarchar](500) NULL,
	[TEMP3] [nvarchar](500) NULL,
	[TEMP4] [nvarchar](500) NULL,
	[TEMP5] [nvarchar](500) NULL,
	[TEMP6] [nvarchar](500) NULL,
	[TEMP7] [nvarchar](500) NULL,
	[TEMP8] [nvarchar](500) NULL,
	[SALESORG] [varchar](20) NULL,
	[SALESOFFICE] [varchar](200) NULL,
	[SALESGROUP] [varchar](20) NULL,
	[SALESNAME] [varchar](20) NULL,
	[CUSTAREA] [varchar](20) NULL
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[CUSTOMERINFO] ON
/******INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (195, NULL, N'朗朗', N'龚颖', N'18201697259,13811053867,30012', NULL, N'1231@163.com', N'北京1', NULL, NULL, NULL, NULL, NULL, N'北京市西城区复兴门内大街1号中银大厦授信执行部1', N'Female', CAST(0x0000A1EA00B2EF6F AS DateTime), N'ssss', N'8347998311', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (196, NULL, NULL, N'吴恩芳', N'3001,1111111,010-66592942', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'北京市西城区复兴门内大街2号中银大厦授信执行部', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (197, NULL, NULL, N'谢霞', N'3001,010-66592942', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'北京市西城区复兴门内大街3号中银大厦授信执行部', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (198, NULL, NULL, N'张耀', N'010-66592942', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'北京市西城区复兴门内大街4号中银大厦授信执行部', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (199, NULL, NULL, N'王纯', N'13901715403', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'上海江苏路470号A座5层', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (200, NULL, NULL, N'王一峰', N'13918947333', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'上海长宁区天山路641号1号楼202室', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (201, NULL, NULL, N'胡佳名', N'18601111385', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'北京市顺义区华英园9号正德人寿大厦', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (202, NULL, NULL, N'范易芳', N'13773178018', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'苏州工业园区中新路56号卫星天线大厦302室', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (203, NULL, NULL, N'米庆涛', N'13311817828', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'上海市沪闵路9450号3楼', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (204, NULL, NULL, N'匡明', N'13923406281', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'深圳市高新科技园中区科发路2号1栋5楼', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (205, NULL, NULL, N'刘峥	', N'13501067203', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'北京市东城区东中街9号东环广场A座三层', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (206, NULL, NULL, N'黄志谦', N'13906031601', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'厦门市软件园二期望海路63号南楼4-5层', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (207, NULL, NULL, N'马建忠', N'13901704089', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'上海浦东新区张扬路620号中融恒瑞国际大厦2403', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (208, NULL, NULL, N'李倩', N'13611007182', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'北京顺义空港工业区B区裕华路12号', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (209, NULL, NULL, N'吴鹏', N'13601055141', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'北京市东城区东长安街1号东方广场东方经贸城西一办公楼3层7-11室', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (210, NULL, NULL, N'张丽', N'18739189890', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'	江苏省 扬州市 广陵区 文汇路金林苑12栋304室', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (211, NULL, NULL, N'安洁', N'18878898773', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'上海市徐汇区中山西路398号', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (212, NULL, NULL, N'温范金', N'13760797244', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'广州市番禺区大学城广外生活区12栋445', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (213, NULL, NULL, N'许宏基', N'13506033306', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'福建省晋江市安海镇对面慕星幼儿园对面 米店', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (214, NULL, NULL, N'黄越鹏', N'13437598835', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'广东省高州市教育路83号', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (215, NULL, NULL, N'郭玩香', N'13560105610', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'广东省广州市天河区龙口东路36号光机电住宅中心5栋1梯1303房', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (216, NULL, NULL, N'魏达文', N'13534061759', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'湖北省石首市笔架山办事处新洲村', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (217, NULL, NULL, N'缪志雄', N'13726241298', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'广东省珠海市香洲区上冲明珠北路68号济生医药连锁有限公司总部三楼行政人事中心', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (218, NULL, NULL, N'留文通', N'13726137272', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'广东省中山市火炬开发区翡翠购物广场安踏专卖', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (219, NULL, NULL, N'余江', N'13602572191', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'深圳市福田区福强路京隆苑18栋7A', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (220, NULL, NULL, N'朱先生', N'13601232322', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (221, NULL, NULL, N'李新', N'13910753254', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'北京市东城区东长安街1号东方广场东方经贸城E2座12层', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (222, NULL, NULL, N'张国强', N'15844059982', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'吉林省长春市汽车产业区腾飞大路2128', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (223, NULL, NULL, N'李沐锴', N'18611625095', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'北京通州区九棵树瑞都国际10号楼3单元202', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (224, NULL, NULL, N'王元', N'', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (225, NULL, NULL, N'胡宇超', N'13703526671', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'山西省太原市迎泽区迎泽南街鼎元时代A座1704', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (226, NULL, NULL, N'程曦', N'13611657132', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'安亭圆国路200号，德尔福派克电气系统有限公司DCS/DEC亚太区模具工厂', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (227, NULL, NULL, N'陈明川', N'18323895232', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'重庆市江北区兴竹路半山华府1栋2704', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (228, NULL, NULL, N'苗静', N'13810255303', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'北京市东城区东直门外大街46号天恒大厦17层', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (229, NULL, NULL, N'刘梦菲', N'13632900187', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'深圳市福田中心区益田路6003号荣超商务中心A座8层', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (230, NULL, NULL, N'高斐', N'13301950888', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'上海市黄浦区山东中路337号7楼', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (231, NULL, NULL, N'邵泽希', N'13911707102', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'朝阳区望京西路甲50号卷石天地大厦A座09层', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (232, NULL, NULL, N'王伟', N'15088774369', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'广州市白云区人和镇高增一寸威尼达厂房', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (233, NULL, NULL, N'孙俊红', N'13910688846', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'北辰东路8号院4号楼', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (234, NULL, NULL, N'唐乃林', N'0512-57875288', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'昆山市花桥镇沿沪大道458号 ', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (235, NULL, NULL, N'冯富强', N'13241604628', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'上海市松江区小昆山镇松蒸公路1289号的普洛斯松江园区之B3U3', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (236, NULL, NULL, N'李来煌', N'18923092125', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'广州市白云区人和镇高增一村维尼达厂房', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (237, NULL, NULL, N'田光', N'13810714577', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'厦门市思明区员当路20号203室', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (238, NULL, NULL, N'陈蔚文', N'13922121860', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'广州市二沙岛烟雨路42号广州万科房地产有限公司', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (239, NULL, NULL, N'王国芳', N'18616511225', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'上海尚博路569弄53号602', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (240, NULL, NULL, N'苏玲', N'13901232069', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'北京市西城区金融大街35号国际企业大厦A座4层', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (241, NULL, NULL, N'孙海涛', N'13991936836', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'陕西省 西安市 雁塔区 丁白路巴黎公馆二号楼一单元1209室', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (242, NULL, NULL, N'李小东', N'13893283887', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'甘肃省 兰州市 城关区 东岗西路230号兰州电脑城405室', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (243, NULL, NULL, N'吴艳明', N'13911559680', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'北京市 大兴区 北京市大兴区旧宫北里1号楼旗利摩托车行', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (244, NULL, NULL, N'沈海卫', N'13564825569', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'上海市 闵行区 东川路2965号上海空间电源研究所门卫室', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (245, NULL, NULL, N'马建辉', N'18610448947', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'海淀区长春桥路11号万柳亿城大厦A座6层', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (246, NULL, NULL, N'戴淙霞', N'1375856566', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N' 浙江省上虞市人民路1001号城市花园裕恒苑6号', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (250, NULL, N'', N'无名', N'18201697259', NULL, N'834799831@qq.com', N'北京', NULL, NULL, NULL, NULL, NULL, N'北京市海淀区', N'Male', NULL, NULL, N'834799831', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (252, NULL, N'test007', N'chris', N'13132132132131', NULL, N'514567839@qq.com', N'beijing', NULL, NULL, N'Y', NULL, NULL, N'beijing jianguomem wai street', N'all', CAST(0x0000A1CF00BA80BB AS DateTime), N'this is a vip', N'514567829', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (254, NULL, N'某集团客户', N'李某', N'1324342432', NULL, N'4565@78979.com', N'上海', NULL, NULL, N'Y', NULL, NULL, N'好吧 好吧', N'byhand', CAST(0x0000A1CF00BBC255 AS DateTime), N'', N'5465465465', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (124, NULL, NULL, N'李静', N'15901275308', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'北京市海淀区中关村南大街6号中电信息大厦3层', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (125, NULL, NULL, N'刘宁', N'13910103054', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'北京市海淀区中关村南大街6号中电信息大厦3层', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (126, NULL, NULL, N'余华', N'13701359783', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'北京市海淀区中关村南大街甲6号铸成大厦A座1105室', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (127, NULL, NULL, N'陈良晟', N'13816825252', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'上海浦东新区银城中路8号（中融碧玉蓝天大厦）1905室', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (128, NULL, NULL, N'乌兰嘎璐', N'18686028111', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'呼和浩特市如意开发区腾飞大道东二纬路呼市信访办东100米', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (129, NULL, NULL, N'李永征', N'13601095609', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'北京市海淀区苏州街16号神州数码大厦', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (130, NULL, NULL, N'侯树云', N'13901098478', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'海淀区首体南路20号国兴家园6号楼1601室', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (131, NULL, NULL, N'梁之平', N'13818889758', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'上海世纪大道100号环球金融中心39楼国泰基金公司', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (132, NULL, NULL, N'刘仁清', N'15870697654', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'江西南昌市东湖区皇殿3号502室', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (133, NULL, NULL, N'张健', N'13701007321', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'王府井大街138号新东安广场写字楼T2座1101室', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (134, NULL, NULL, N'刘晶', N'13911616100', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'北京市南三环中路恒松园6号楼', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (135, NULL, NULL, N'思妤', N'18621852795', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'上海市卢湾区淮海中路99号大上海时代广场办公楼23楼2308室', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (136, NULL, NULL, N'裴永日', N'13911758451', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'北京市朝阳区东三环中路39号建外soho小区1号楼903室', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (137, NULL, NULL, N'唐爱民', N'15059557777', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'厦门市湖里区观音山国际运营中心A3地块2号楼10楼', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (138, NULL, NULL, N'杨闳超', N'18611858556', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'北京市海淀区远大路世纪城远大园三区1号楼1B ', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (139, NULL, NULL, N'李辉', N'13838066633', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'河南省郑州市高新区金梭路8号', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (140, NULL, NULL, N'曹建伟', N'13838095258', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'河南 郑州 管城区陇海东路货站北街交叉口绿都嘉园3-1-11西', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (141, NULL, NULL, N'侯科伟', N'18600097097', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'朝阳区四惠地铁站京通大厦西区5层', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (142, NULL, NULL, N'文雅', N'13916662898', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'上海市浦东新区丁香路1299弄23楼202室', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (143, NULL, NULL, N'赵胜利', N'13601292369', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'河北省廊坊市经济技术开发区新源东道新奥工业园区A座630', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (144, NULL, NULL, N'程颖', N'13911126820', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'北京市朝阳区东三环中路39号建外soho东区6号楼3层', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (145, NULL, NULL, N'熊贞', N'13601068652', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'北京市朝阳东三环北路16号全国农业展览馆文化产品楼商品公司', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (146, NULL, NULL, N'王静', N'15801464209', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'北京市朝阳区甜水西园万科公园五号19-2-901', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (147, NULL, NULL, N'张新跃', N'13911710726', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'北京市朝阳区望京阜通东大街6号方恒国际中心B座506室', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (148, NULL, NULL, N'王晓丹', N'13521952525', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'北京市朝阳区望京阜通东大街6号方恒国际中心B座9层', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (149, NULL, NULL, N'郭玉鹏', N'13530005758', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'深圳市福田区益田村120栋21B', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (150, NULL, NULL, N'李俊涛', N'13901061698', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'北京市朝阳区霄云路26号鹏润大厦B座7层', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (151, NULL, NULL, N'韩德鹏', N'18653202678', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'北京市海淀区海淀大街3号鼎好电子大厦B座8层', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (152, NULL, NULL, N'王岩松', N'13910603176', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'北京市海淀区海淀大街3号鼎好电子大厦B座8层', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (153, NULL, NULL, N'骆春华', N'13601239180', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'北京市海淀区海淀大街3号鼎好电子大厦B座8层', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (154, NULL, NULL, N'王欣', N'13601310673', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'北京市海淀区小营西路三十三号金山软件大厦', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (155, NULL, NULL, N'张旻翚', N'13511066295', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'东三环北路甲26号京广桥东北角博瑞大厦7层 3G门户', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (156, NULL, NULL, N'王厚生', N'18660256656', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'青岛市城阳区交警大队棘红滩中队', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (157, NULL, NULL, N'李亚平', N'13509633061', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'深圳南山区华侨城恩平街 锦绣花园二期d栋13b', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (158, NULL, NULL, N'夏勇', N'13510466815', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'深圳市南山区东滨路新街口大厦C座706室', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (159, NULL, NULL, N'黄花', N'13601862192', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'上海市浦东桃林路815弄6号302', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (160, NULL, NULL, N'樊力嘉', N'13701073998', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'北京市西城区金融大街甲九号金融街中心一层中债信用增进公司', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (161, NULL, NULL, N'冯君', N'18831628686', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'河北廊坊开发区新源东道新奥科技园A楼608', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (162, NULL, NULL, N'赵一工', N'13801119669', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'北京市海淀区中关村东路1号院8号楼清华科技园启迪科技大厦C座22层', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (163, NULL, NULL, N'马志成', N'18611752566', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'北京市建国门外大街1号国贸大厦10层', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (164, NULL, NULL, N'杨宁', N'18610216008', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'北京昌平区回龙观七里渠慧聪园总部基地', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (165, NULL, NULL, N'谈磊	', N'13521816968', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'北京市海淀区东北旺西路8号中关村软件园20号楼', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (166, NULL, NULL, N'高四海', N'13916384007', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'上海市衡山路922号建汇大厦35F', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (167, NULL, NULL, N'黄康', N'13901007152', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'北京市海淀区三里河路5号A座206室', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (168, NULL, NULL, N'周罕见', N'13911587379', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'北京海淀区复兴路11号中央电视台西北门广告经营管理中心', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
GO
print 'Processed 100 total records'
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (169, NULL, NULL, N'金美勇', N'13818915628', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'上海市浦东新区耀华路699号环江公司', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (170, NULL, NULL, N'颜晶', N'13912632171', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'苏州新区金枫路655号B1幢（安达讯物流）', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (171, NULL, NULL, N'彭荣华', N'13910787935', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'北京市西城区西直门外大街1号西环广场T2座21层', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (172, NULL, NULL, N'崔志新', N'18610201617', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'北京市西城区新壁街18号楼9单元405', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (173, NULL, NULL, N'朱晓阳', N'13892874028', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'西安市互助路2号建国饭店工程部工程部', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (174, NULL, NULL, N'戈先云', N'18665305980', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'深圳市罗湖区深南东路2102号振华大厦4楼', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (175, NULL, NULL, N'朱仕国', N'13509653429', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'深圳市罗湖区深南东路2102号振华大厦4楼', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (176, NULL, NULL, N'黄玲', N'13720093839', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'北京市朝阳区北辰西路8号北辰世纪中心A座1层', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (177, NULL, NULL, N'叶兵', N'13788958409', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'上海市天山路600弄4号思创大厦15楼A/D座', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (178, NULL, NULL, N'肖昭恩', N'13906057485', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'广州市白云国际机场候机楼主楼一层C9106', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (179, NULL, NULL, N'谭双双', N'15814011902', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'深圳市宝安区宝源路F518时尚创意园F17栋206', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (180, NULL, NULL, N'董毅然', N'13811636031', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'北京市丰台区丰管路16号西国贸A1座3066室', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (181, NULL, NULL, N'张晓', N'15010382668', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'北京市朝阳区三丰北里1号悠唐国际A座17层', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (182, NULL, NULL, N'马建辉', N'18610448947', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'北京市海淀区长春桥路11号万柳亿城大厦A座6层', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (183, NULL, NULL, N'陈俊鹏', N'18911352622', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'北京市朝阳区建国门外大街乙12号双子座大厦西塔20层', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (184, NULL, NULL, N'王浩', N'13671185558', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'北京市海淀区海淀大街3号鼎好电子大厦A座1916', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (185, NULL, NULL, N'魏灵玲', N'18601128299', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'北京市海淀区中关村南大街甲12号寰太大厦16层', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (186, NULL, NULL, N'马莉娜', N'13511076848', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'北京市海淀区中关村南大街甲12号寰太大厦16层', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (187, NULL, NULL, N'熊峰鸣', N'15817298101', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'深圳市南山区科技园科苑北路东方信息港2栋1楼106', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (188, NULL, NULL, N'杨宁', N'18610216008', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'北京市昌平区七里渠慧聪园总部基地', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (189, NULL, NULL, N'王志和', N'18610216078', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'北京市昌平区七里渠慧聪园总部基地', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (190, NULL, NULL, N'李艳坪', N'13691118570', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'北京市昌平区七里渠慧聪园总部基地', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (191, NULL, NULL, N'虞明姬', N'15618981875', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'上海市闵行区都市路3800弄54号', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (192, NULL, NULL, N'王铁鑫', N'15210066337', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'北京市东城区东直门北大街甲6号院11号楼', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (193, NULL, NULL, N'梁洪军', N'18610761030', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'北京朝阳区建国门外大街24号燕华苑3座1804室', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (194, NULL, NULL, N'原强', N'13772060717', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, N'陕西省西安市长安区紫微田园都市H区19号楼1单元402', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (248, NULL, N'朗泰', N'无名', N'18201697259', NULL, N'834799831@qq.com', N'北京', NULL, NULL, NULL, NULL, NULL, N'北京海淀区', N'Male', NULL, NULL, N'834799831', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (253, NULL, N'某集团客户', N'张某', N'8887799,0104454602', NULL, N'545445@465465.com', N'珠海', NULL, NULL, N'Y', NULL, NULL, N'哇哈哈', N'Male', CAST(0x0000A1D200A97DC5 AS DateTime), N'', N'78897979', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (255, NULL, N'无', N'杨凯', N'', NULL, N'', N'', NULL, NULL, NULL, NULL, NULL, N'', N'byhand', CAST(0x0000A1E100F3F66E AS DateTime), N'', N'', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (256, NULL, N'无', N'杨凯', N'18669018554', NULL, N'', N'', NULL, NULL, NULL, NULL, NULL, N'', N'byhand', CAST(0x0000A1E100F62E25 AS DateTime), N'', N'', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (258, NULL, N'授信1', N'龚颖1', N'3001,010-66592942,2001', NULL, N'1231@163.com', N'北京1', NULL, NULL, NULL, NULL, NULL, N'北京市西城区复兴门内大街1号中银大厦授信执行部1', N'Male', NULL, NULL, N'8347998311', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSTOMERINFO] ([PK_CUSTOMERINFO], [CUSTOMERNO], [CUSTOMERNAME], [CUSTLINKMAN], [CUSTPHONENO], [POSTCODE], [EMAILADDR], [NETHERLANDS], [CUSTTYPE], [CUSTLEVEL], [CUSTSTATUS], [PROVINCE], [CITY], [CUSTADDR], [INFOSOURCE], [UPDATETIME], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4], [TEMP5], [TEMP6], [TEMP7], [TEMP8], [SALESORG], [SALESOFFICE], [SALESGROUP], [SALESNAME], [CUSTAREA]) VALUES (257, NULL, N'朗泰恒盛', N'测试c', N'99999999999,66666666,0000000000', NULL, N'222@163.com', N'北京2222', NULL, NULL, NULL, NULL, NULL, N'22222222222222222222', N'Female', NULL, NULL, N'2222222222', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
SET IDENTITY_INSERT [dbo].[CUSTOMERINFO] OFF******/
/****** Object:  Table [dbo].[CUSPHONELIST]    Script Date: 06/27/2013 11:34:09 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[CUSPHONELIST](
	[PK_CUSPHONELIST] [int] IDENTITY(1,1) NOT NULL,
	[PK_CUSTOMERINFO] [int] NOT NULL,
	[CUSTLINKNAME] [nvarchar](100) NULL,
	[PHONENO] [varchar](30) NULL,
	[SYNSTATUS] [varchar](10) NULL,
	[UPDATETIME] [datetime] NOT NULL,
	[NOLEVEL] [varchar](10) NULL,
	[REMARK] [nvarchar](500) NULL,
	[TEMP1] [nvarchar](500) NULL,
	[TEMP2] [nvarchar](500) NULL,
	[TEMP3] [nvarchar](500) NULL,
	[TEMP4] [nvarchar](500) NULL
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/******SET IDENTITY_INSERT [dbo].[CUSPHONELIST] ON
INSERT [dbo].[CUSPHONELIST] ([PK_CUSPHONELIST], [PK_CUSTOMERINFO], [CUSTLINKNAME], [PHONENO], [SYNSTATUS], [UPDATETIME], [NOLEVEL], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4]) VALUES (2, 196, N'吴恩芳', N'010-66592942', N'Nsyn', CAST(0x0000A1CC0105BF8F AS DateTime), N'1', NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSPHONELIST] ([PK_CUSPHONELIST], [PK_CUSTOMERINFO], [CUSTLINKNAME], [PHONENO], [SYNSTATUS], [UPDATETIME], [NOLEVEL], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4]) VALUES (3, 197, N'谢霞', N'010-66592942', N'Nsyn', CAST(0x0000A1CC010B92D4 AS DateTime), N'1', NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSPHONELIST] ([PK_CUSPHONELIST], [PK_CUSTOMERINFO], [CUSTLINKNAME], [PHONENO], [SYNSTATUS], [UPDATETIME], [NOLEVEL], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4]) VALUES (4, 198, N'张耀', N'010-66592942', N'Nsyn', CAST(0x0000A1CC010BB9E5 AS DateTime), N'1', NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSPHONELIST] ([PK_CUSPHONELIST], [PK_CUSTOMERINFO], [CUSTLINKNAME], [PHONENO], [SYNSTATUS], [UPDATETIME], [NOLEVEL], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4]) VALUES (49, 196, N'吴恩芳', N'3001', NULL, CAST(0x0000A1E8012A922E AS DateTime), NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSPHONELIST] ([PK_CUSPHONELIST], [PK_CUSTOMERINFO], [CUSTLINKNAME], [PHONENO], [SYNSTATUS], [UPDATETIME], [NOLEVEL], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4]) VALUES (6, 253, N'张某', N'8887799', NULL, CAST(0x0000A1CF00BAEC36 AS DateTime), NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSPHONELIST] ([PK_CUSPHONELIST], [PK_CUSTOMERINFO], [CUSTLINKNAME], [PHONENO], [SYNSTATUS], [UPDATETIME], [NOLEVEL], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4]) VALUES (8, 253, N'张某', N'0104454602', NULL, CAST(0x0000A1CF00BC9208 AS DateTime), NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSPHONELIST] ([PK_CUSPHONELIST], [PK_CUSTOMERINFO], [CUSTLINKNAME], [PHONENO], [SYNSTATUS], [UPDATETIME], [NOLEVEL], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4]) VALUES (10, 196, N'吴恩芳', N'1111111', N'Nsyn', CAST(0x0000A1D40102E97D AS DateTime), N'1', NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSPHONELIST] ([PK_CUSPHONELIST], [PK_CUSTOMERINFO], [CUSTLINKNAME], [PHONENO], [SYNSTATUS], [UPDATETIME], [NOLEVEL], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4]) VALUES (38, 257, N'测试c', N'99999999999', NULL, CAST(0x0000A1E800CF692D AS DateTime), NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSPHONELIST] ([PK_CUSPHONELIST], [PK_CUSTOMERINFO], [CUSTLINKNAME], [PHONENO], [SYNSTATUS], [UPDATETIME], [NOLEVEL], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4]) VALUES (7, 252, N'chris', N'13132132132131', NULL, CAST(0x0000A1CF00BAEF24 AS DateTime), NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSPHONELIST] ([PK_CUSPHONELIST], [PK_CUSTOMERINFO], [CUSTLINKNAME], [PHONENO], [SYNSTATUS], [UPDATETIME], [NOLEVEL], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4]) VALUES (9, 254, N'李某', N'1324342432', NULL, CAST(0x0000A1CF00BD4AFA AS DateTime), NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSPHONELIST] ([PK_CUSPHONELIST], [PK_CUSTOMERINFO], [CUSTLINKNAME], [PHONENO], [SYNSTATUS], [UPDATETIME], [NOLEVEL], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4]) VALUES (50, 197, N'谢霞', N'3001', NULL, CAST(0x0000A1E900AFD8C3 AS DateTime), NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSPHONELIST] ([PK_CUSPHONELIST], [PK_CUSTOMERINFO], [CUSTLINKNAME], [PHONENO], [SYNSTATUS], [UPDATETIME], [NOLEVEL], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4]) VALUES (36, 257, N'测试c', N'66666666', NULL, CAST(0x0000A1E800CF6924 AS DateTime), NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSPHONELIST] ([PK_CUSPHONELIST], [PK_CUSTOMERINFO], [CUSTLINKNAME], [PHONENO], [SYNSTATUS], [UPDATETIME], [NOLEVEL], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4]) VALUES (37, 257, N'测试c', N'0000000000', NULL, CAST(0x0000A1E800CF6925 AS DateTime), NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSPHONELIST] ([PK_CUSPHONELIST], [PK_CUSTOMERINFO], [CUSTLINKNAME], [PHONENO], [SYNSTATUS], [UPDATETIME], [NOLEVEL], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4]) VALUES (61, 195, N'龚颖', N'18201697259', NULL, CAST(0x0000A1EA00B2EF71 AS DateTime), NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSPHONELIST] ([PK_CUSPHONELIST], [PK_CUSTOMERINFO], [CUSTLINKNAME], [PHONENO], [SYNSTATUS], [UPDATETIME], [NOLEVEL], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4]) VALUES (62, 195, N'龚颖', N'13811053867', NULL, CAST(0x0000A1EA00B2EF72 AS DateTime), NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[CUSPHONELIST] ([PK_CUSPHONELIST], [PK_CUSTOMERINFO], [CUSTLINKNAME], [PHONENO], [SYNSTATUS], [UPDATETIME], [NOLEVEL], [REMARK], [TEMP1], [TEMP2], [TEMP3], [TEMP4]) VALUES (63, 195, N'龚颖', N'30012', NULL, CAST(0x0000A1EA00B2EF72 AS DateTime), NULL, NULL, NULL, NULL, NULL, NULL)
SET IDENTITY_INSERT [dbo].[CUSPHONELIST] OFF******/
/****** Object:  Table [dbo].[CALLOUT_STAT_YEAR]    Script Date: 06/27/2013 11:34:09 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[CALLOUT_STAT_YEAR](
	[ID] [int] NOT NULL,
	[SKILL_ID] [varchar](40) NULL,
	[SKILL_DESC] [varchar](60) NULL,
	[STAT_TIME] [varchar](20) NULL,
	[TIME] [varchar](20) NULL,
	[CALLOUT_NUM] [decimal](32, 0) NULL,
	[CALLOUT_SUCC_NUM] [decimal](32, 0) NULL,
	[CALLOUT_SUCC_RATE] [decimal](32, 4) NULL,
	[IVR_CALLOUT_NUM] [decimal](32, 0) NULL,
	[IVR_CALLOUT_SNUM] [decimal](32, 0) NULL,
	[IVR_CALLOUT_SRATE] [decimal](32, 4) NULL,
	[MANUAL_CALLOUT_NUM] [decimal](32, 0) NULL,
	[MANUAL_CALLOUT_SNUM] [decimal](32, 0) NULL,
	[MANUAL_CALLOUT_SRATE] [decimal](32, 4) NULL,
	[AVG_TALKING_TIME] [decimal](32, 0) NULL
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[CALLOUT_STAT_MONTH]    Script Date: 06/27/2013 11:34:09 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[CALLOUT_STAT_MONTH](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[SKILL_ID] [varchar](40) NULL,
	[SKILL_DESC] [varchar](60) NULL,
	[STAT_TIME] [varchar](20) NULL,
	[TIME] [varchar](20) NULL,
	[CALLOUT_NUM] [decimal](32, 0) NULL,
	[CALLOUT_SUCC_NUM] [decimal](32, 0) NULL,
	[CALLOUT_SUCC_RATE] [decimal](32, 4) NULL,
	[IVR_CALLOUT_NUM] [decimal](32, 0) NULL,
	[IVR_CALLOUT_SNUM] [decimal](32, 0) NULL,
	[IVR_CALLOUT_SRATE] [decimal](32, 4) NULL,
	[MANUAL_CALLOUT_NUM] [decimal](32, 0) NULL,
	[MANUAL_CALLOUT_SNUM] [decimal](32, 0) NULL,
	[MANUAL_CALLOUT_SRATE] [decimal](32, 4) NULL,
	[AVG_TALKING_TIME] [decimal](32, 0) NULL
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[CALLOUT_STAT_DAY]    Script Date: 06/27/2013 11:34:09 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[CALLOUT_STAT_DAY](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[SKILL_ID] [varchar](40) NULL,
	[SKILL_DESC] [varchar](60) NULL,
	[STAT_TIME] [varchar](20) NULL,
	[TIME] [varchar](20) NULL,
	[CALLOUT_NUM] [decimal](32, 0) NULL,
	[CALLOUT_SUCC_NUM] [decimal](32, 0) NULL,
	[CALLOUT_SUCC_RATE] [decimal](32, 4) NULL,
	[IVR_CALLOUT_NUM] [decimal](32, 0) NULL,
	[IVR_CALLOUT_SNUM] [decimal](32, 0) NULL,
	[IVR_CALLOUT_SRATE] [decimal](32, 4) NULL,
	[MANUAL_CALLOUT_NUM] [decimal](32, 0) NULL,
	[MANUAL_CALLOUT_SNUM] [decimal](32, 0) NULL,
	[MANUAL_CALLOUT_SRATE] [decimal](32, 4) NULL,
	[AVG_TALKING_TIME] [decimal](32, 0) NULL
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[CALLDETAIL]    Script Date: 06/27/2013 11:34:09 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[CALLDETAIL](
	[PK_CALLDETAIL] [varchar](50) NOT NULL,
	[CALLDETAILID] [varchar](50) NOT NULL,
	[CALLINTIME] [varchar](50) NULL,
	[ANI] [varchar](50) NULL,
	[ANIAREA] [varchar](50) NULL,
	[ANICITY] [varchar](50) NULL,
	[BUSITYPE] [varchar](50) NULL,
	[SVRRESULT] [varchar](50) NULL,
	[LEAVETIME] [varchar](50) NULL,
	[UCID] [varchar](50) NULL,
	[CREATETYPE] [varchar](50) NULL,
	[ISLOST] [varchar](50) NULL,
	[AGENTID] [varchar](50) NULL,
	[N1] [varchar](50) NULL,
	[N2] [varchar](50) NULL,
	[N3] [varchar](50) NULL
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[bd_userinforole]    Script Date: 06/27/2013 11:34:09 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[bd_userinforole](
	[PK_USERINFOROLE] [int] IDENTITY(1,1) NOT NULL,
	[pk_userinfo] [int] NOT NULL,
	[pk_role] [int] NOT NULL
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[bd_userinforole] ON
INSERT [dbo].[bd_userinforole] ([PK_USERINFOROLE], [pk_userinfo], [pk_role]) VALUES (2, 6, 10)
INSERT [dbo].[bd_userinforole] ([PK_USERINFOROLE], [pk_userinfo], [pk_role]) VALUES (11, 14, 8)
INSERT [dbo].[bd_userinforole] ([PK_USERINFOROLE], [pk_userinfo], [pk_role]) VALUES (19, 12, 8)
INSERT [dbo].[bd_userinforole] ([PK_USERINFOROLE], [pk_userinfo], [pk_role]) VALUES (20, 1, 8)
INSERT [dbo].[bd_userinforole] ([PK_USERINFOROLE], [pk_userinfo], [pk_role]) VALUES (23, 7, 8)
INSERT [dbo].[bd_userinforole] ([PK_USERINFOROLE], [pk_userinfo], [pk_role]) VALUES (24, 7, 10)
INSERT [dbo].[bd_userinforole] ([PK_USERINFOROLE], [pk_userinfo], [pk_role]) VALUES (25, 13, 8)
INSERT [dbo].[bd_userinforole] ([PK_USERINFOROLE], [pk_userinfo], [pk_role]) VALUES (26, 19, 8)
INSERT [dbo].[bd_userinforole] ([PK_USERINFOROLE], [pk_userinfo], [pk_role]) VALUES (27, 20, 11)
INSERT [dbo].[bd_userinforole] ([PK_USERINFOROLE], [pk_userinfo], [pk_role]) VALUES (28, 21, 11)
INSERT [dbo].[bd_userinforole] ([PK_USERINFOROLE], [pk_userinfo], [pk_role]) VALUES (29, 22, 11)
INSERT [dbo].[bd_userinforole] ([PK_USERINFOROLE], [pk_userinfo], [pk_role]) VALUES (34, 23, 11)
INSERT [dbo].[bd_userinforole] ([PK_USERINFOROLE], [pk_userinfo], [pk_role]) VALUES (31, 24, 11)
INSERT [dbo].[bd_userinforole] ([PK_USERINFOROLE], [pk_userinfo], [pk_role]) VALUES (36, 25, 11)
INSERT [dbo].[bd_userinforole] ([PK_USERINFOROLE], [pk_userinfo], [pk_role]) VALUES (35, 26, 11)
SET IDENTITY_INSERT [dbo].[bd_userinforole] OFF
/****** Object:  Table [dbo].[bd_rolemenu]    Script Date: 06/27/2013 11:34:09 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[bd_rolemenu](
	[pk_rolemenu] [int] IDENTITY(1,1) NOT NULL,
	[pk_role] [int] NOT NULL,
	[pk_menu] [int] NOT NULL
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[bd_rolemenu] ON
INSERT [dbo].[bd_rolemenu] ([pk_rolemenu], [pk_role], [pk_menu]) VALUES (161, 10, 2)
INSERT [dbo].[bd_rolemenu] ([pk_rolemenu], [pk_role], [pk_menu]) VALUES (176, 8, 25)
INSERT [dbo].[bd_rolemenu] ([pk_rolemenu], [pk_role], [pk_menu]) VALUES (177, 8, 29)
INSERT [dbo].[bd_rolemenu] ([pk_rolemenu], [pk_role], [pk_menu]) VALUES (178, 8, 23)
INSERT [dbo].[bd_rolemenu] ([pk_rolemenu], [pk_role], [pk_menu]) VALUES (179, 8, 24)
INSERT [dbo].[bd_rolemenu] ([pk_rolemenu], [pk_role], [pk_menu]) VALUES (180, 8, 30)
INSERT [dbo].[bd_rolemenu] ([pk_rolemenu], [pk_role], [pk_menu]) VALUES (181, 8, 26)
INSERT [dbo].[bd_rolemenu] ([pk_rolemenu], [pk_role], [pk_menu]) VALUES (182, 8, 31)
INSERT [dbo].[bd_rolemenu] ([pk_rolemenu], [pk_role], [pk_menu]) VALUES (183, 8, 32)
INSERT [dbo].[bd_rolemenu] ([pk_rolemenu], [pk_role], [pk_menu]) VALUES (184, 8, 34)
INSERT [dbo].[bd_rolemenu] ([pk_rolemenu], [pk_role], [pk_menu]) VALUES (185, 8, 47)
INSERT [dbo].[bd_rolemenu] ([pk_rolemenu], [pk_role], [pk_menu]) VALUES (186, 8, 28)
INSERT [dbo].[bd_rolemenu] ([pk_rolemenu], [pk_role], [pk_menu]) VALUES (187, 8, 3)
INSERT [dbo].[bd_rolemenu] ([pk_rolemenu], [pk_role], [pk_menu]) VALUES (188, 8, 38)
INSERT [dbo].[bd_rolemenu] ([pk_rolemenu], [pk_role], [pk_menu]) VALUES (189, 8, 40)
INSERT [dbo].[bd_rolemenu] ([pk_rolemenu], [pk_role], [pk_menu]) VALUES (190, 8, 41)
INSERT [dbo].[bd_rolemenu] ([pk_rolemenu], [pk_role], [pk_menu]) VALUES (191, 8, 39)
INSERT [dbo].[bd_rolemenu] ([pk_rolemenu], [pk_role], [pk_menu]) VALUES (192, 8, 42)
INSERT [dbo].[bd_rolemenu] ([pk_rolemenu], [pk_role], [pk_menu]) VALUES (193, 8, 43)
INSERT [dbo].[bd_rolemenu] ([pk_rolemenu], [pk_role], [pk_menu]) VALUES (194, 8, 48)
INSERT [dbo].[bd_rolemenu] ([pk_rolemenu], [pk_role], [pk_menu]) VALUES (195, 8, 2)
INSERT [dbo].[bd_rolemenu] ([pk_rolemenu], [pk_role], [pk_menu]) VALUES (196, 8, 10)
INSERT [dbo].[bd_rolemenu] ([pk_rolemenu], [pk_role], [pk_menu]) VALUES (197, 8, 5)
INSERT [dbo].[bd_rolemenu] ([pk_rolemenu], [pk_role], [pk_menu]) VALUES (280, 11, 25)
INSERT [dbo].[bd_rolemenu] ([pk_rolemenu], [pk_role], [pk_menu]) VALUES (282, 11, 24)
INSERT [dbo].[bd_rolemenu] ([pk_rolemenu], [pk_role], [pk_menu]) VALUES (286, 11, 32)
INSERT [dbo].[bd_rolemenu] ([pk_rolemenu], [pk_role], [pk_menu]) VALUES (287, 11, 34)
INSERT [dbo].[bd_rolemenu] ([pk_rolemenu], [pk_role], [pk_menu]) VALUES (281, 11, 23)
INSERT [dbo].[bd_rolemenu] ([pk_rolemenu], [pk_role], [pk_menu]) VALUES (283, 11, 30)
INSERT [dbo].[bd_rolemenu] ([pk_rolemenu], [pk_role], [pk_menu]) VALUES (284, 11, 26)
INSERT [dbo].[bd_rolemenu] ([pk_rolemenu], [pk_role], [pk_menu]) VALUES (285, 11, 31)
SET IDENTITY_INSERT [dbo].[bd_rolemenu] OFF
/****** Object:  Table [dbo].[bd_role]    Script Date: 06/27/2013 11:34:09 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[bd_role](
	[pk_role] [int] IDENTITY(1,1) NOT NULL,
	[rolename] [varchar](20) NULL,
	[description] [varchar](50) NULL
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[bd_role] ON
INSERT [dbo].[bd_role] ([pk_role], [rolename], [description]) VALUES (8, N'系统管理员', N'')
INSERT [dbo].[bd_role] ([pk_role], [rolename], [description]) VALUES (10, N'产品维护', N'')
INSERT [dbo].[bd_role] ([pk_role], [rolename], [description]) VALUES (11, N'普通座席', N'')
SET IDENTITY_INSERT [dbo].[bd_role] OFF
/****** Object:  Table [dbo].[bd_jobmsg]    Script Date: 06/27/2013 11:34:09 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[bd_jobmsg](
	[Job_id] [int] NOT NULL,
	[Job_name] [varchar](100) NULL,
	[CronExpression] [varchar](32) NULL,
	[Job_state] [varchar](4) NULL,
	[Create_time] [datetime] NULL,
	[Last_modify_time] [datetime] NULL,
	[Create_oper] [varchar](32) NULL,
	[Job_year] [varchar](4) NULL,
	[Job_month] [varchar](4) NULL,
	[Job_day] [varchar](4) NULL,
	[Job_week] [varchar](4) NULL,
	[Job_hour] [varchar](4) NULL,
	[Job_minute] [varchar](4) NULL,
	[Job_second] [varchar](4) NULL,
	[Job_beanName] [varchar](50) NULL,
	[remark] [varchar](500) NULL
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[bd_jobmsg] ([Job_id], [Job_name], [CronExpression], [Job_state], [Create_time], [Last_modify_time], [Create_oper], [Job_year], [Job_month], [Job_day], [Job_week], [Job_hour], [Job_minute], [Job_second], [Job_beanName], [remark]) VALUES (1, N'同步客户资料', N'0 01 10 * * ? *', N'N', CAST(0x0000A186014DAC4B AS DateTime), CAST(0x0000A1C700B4AB76 AS DateTime), NULL, N'*', N'*', N'*', N'?', N'10', N'01', N'0', N'synCustomerTrigger', N'')
INSERT [dbo].[bd_jobmsg] ([Job_id], [Job_name], [CronExpression], [Job_state], [Create_time], [Last_modify_time], [Create_oper], [Job_year], [Job_month], [Job_day], [Job_week], [Job_hour], [Job_minute], [Job_second], [Job_beanName], [remark]) VALUES (4, N'同步IPCC报表数据-日报', N'0 09 12 * * ? *', N'N', CAST(0x0000A1B80104B0AB AS DateTime), CAST(0x0000A1C800B0B612 AS DateTime), NULL, N'*', N'*', N'*', N'?', N'12', N'09', N'0', N'synReportFormsTriggerDay', N'')
INSERT [dbo].[bd_jobmsg] ([Job_id], [Job_name], [CronExpression], [Job_state], [Create_time], [Last_modify_time], [Create_oper], [Job_year], [Job_month], [Job_day], [Job_week], [Job_hour], [Job_minute], [Job_second], [Job_beanName], [remark]) VALUES (5, N'同步坐席及技能组信息', N'0 25 13 * * ? *', N'N', CAST(0x0000A1BD00AB7034 AS DateTime), CAST(0x0000A1CC0111C1DA AS DateTime), NULL, N'*', N'*', N'*', N'?', N'13', N'25', N'0', N'synReportFormsDetailTrigger', N'')
INSERT [dbo].[bd_jobmsg] ([Job_id], [Job_name], [CronExpression], [Job_state], [Create_time], [Last_modify_time], [Create_oper], [Job_year], [Job_month], [Job_day], [Job_week], [Job_hour], [Job_minute], [Job_second], [Job_beanName], [remark]) VALUES (6, N'同步IPCC报表数据-月报', N'0 30 11 * * ? *', N'N', CAST(0x0000A1C700B5AF46 AS DateTime), NULL, NULL, N'*', N'*', N'*', N'?', N'11', N'30', N'0', N'synReportFormsTriggerMonth', N'')
INSERT [dbo].[bd_jobmsg] ([Job_id], [Job_name], [CronExpression], [Job_state], [Create_time], [Last_modify_time], [Create_oper], [Job_year], [Job_month], [Job_day], [Job_week], [Job_hour], [Job_minute], [Job_second], [Job_beanName], [remark]) VALUES (7, N'同步IPCC报表数据-年报', N'0 04 11 * * ? *', N'N', CAST(0x0000A1C700B6067F AS DateTime), NULL, NULL, N'*', N'*', N'*', N'?', N'11', N'04', N'0', N'synReportFormsTriggerYear', N'')
/****** Object:  Table [dbo].[bd_dictdetail]    Script Date: 06/27/2013 11:34:09 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[bd_dictdetail](
	[PK_DICTDETAIL] [int] IDENTITY(1,1) NOT NULL,
	[PK_DICT] [int] NOT NULL,
	[CODE] [varchar](100) NULL,
	[TITLE] [varchar](100) NULL,
	[VALUE] [varchar](100) NULL,
	[ISVALID] [varchar](2) NULL,
	[REMARK] [varchar](100) NULL,
	[DEFAULTORDER] [int] NULL
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[bd_dictdetail] ON
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (3, 48, N'REGUSERS', N'用户数', NULL, N'Y', N'', 1)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (9, 52, N'LOGTYPE-SC', N'删除', NULL, N'Y', N'', 1)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (10, 52, N'LOGTYPE-XZ', N'新增', NULL, N'Y', N'', 1)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (11, 52, N'LOGTYPE-DC', N'登出', NULL, N'Y', N'', 0)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (14, 55, N'Liveneo', N'朗泰恒盛', NULL, N'Y', N'', 1)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (16, 56, N'未审核', N'未审核', NULL, N'Y', N'', 1)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (21, 60, N'O_Sampledepend', N'咨询', NULL, N'Y', N'Sampletemplate', 1)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (22, 60, N'O_Amodeldepend', N'渠道', NULL, N'Y', N'Sampletemplate', 2)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (23, 60, N'O_SampleReq', N'采购', NULL, N'Y', N'Sampletemplate', 3)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (24, 60, N'O_OrderDelivery', N'投诉', NULL, N'Y', N'Order', 4)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (25, 60, N'O_Onsiteservice', N'售后', NULL, N'Y', N'Onsiteservice', 5)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (26, 60, N'O_Complainthand', N'退换货', NULL, N'Y', N'Complainthandling', 6)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (27, 60, N'O_ReturnReq', N'其他', NULL, N'Y', N'Complainthandling', 7)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (28, 61, N'Order', N'订单', NULL, N'Y', N'', 1)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (29, 61, N'Sampletemplate', N'小样样板', NULL, N'Y', N'', 2)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (30, 61, N'Onsiteservice', N'现场服务', NULL, N'Y', N'', 3)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (31, 61, N'Complainthandling', N'投诉处理', NULL, N'Y', N'', 4)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (32, 62, N'customer', N'客户', NULL, N'Y', N'', 1)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (33, 62, N'sell', N'销售', NULL, N'Y', N'', 2)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (34, 63, N'wcl', N'未处理', NULL, N'Y', N'', 1)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (35, 63, N'dhxcl', N'待后续处理', NULL, N'Y', N'', 2)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (36, 63, N'ywc', N'已完成', NULL, N'Y', N'', 3)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (37, 63, N'yjd', N'已结单', NULL, N'Y', N'', 4)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (38, 64, N'ylsycyc', N'依赖书延迟异常', NULL, N'Y', N'', 1)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (39, 64, N'wlwhycyc', N'物料维护延迟异常', NULL, N'Y', N'', 2)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (40, 64, N'ddycyc', N'订单延迟异常 ', NULL, N'Y', N'', 3)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (41, 64, N'wljhyc', N'物流交货异常', NULL, N'Y', N'', 4)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (42, 64, N'ddjdyc', N'订单进度的查询', NULL, N'Y', N'', 5)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (43, 65, N'byhand', N'手工创建', NULL, N'Y', N'', 1)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (44, 65, N'datesyn', N'资料同步', NULL, N'Y', N'', 2)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (45, 66, N'S_delayExc', N'小样、样板延迟异常', NULL, N'Y', N'', 1)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (46, 66, N'S_repeatExc', N'小样、样板重复异常', NULL, N'Y', N'', 2)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (47, 66, N'S_majorMeet', N'重大项目的满足', NULL, N'Y', N'', 3)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (48, 66, N'S_progressQuery', N'进度的查询', NULL, N'Y', N'', 4)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (49, 67, N'On_serviceDispatch', N'服务人员对重大项目和特大项目的调配（调动大区、战略客户、应用管理部的全国资源）', NULL, N'Y', N'', 1)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (50, 67, N'On_sampleDispatch', N'对重大项目和特大项目的样漆/样板/现场试刷/样板楼的人员分配 ', NULL, N'Y', N'', 2)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (51, 67, N'On_specialDisplay', N'对特殊效果和产品的调样，样板的工厂间分配', NULL, N'Y', N'', 3)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (52, 68, N'C_ComplaintsExc', N'投诉退货、换货异常', NULL, N'Y', N'', 1)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (53, 68, N'C_compensateExc', N'样品赔偿异常', NULL, N'Y', N'', 2)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (54, 68, N'C_produceExc', N'换货生产异常', NULL, N'Y', N'', 3)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (55, 68, N'C_cchedule', N'进度查询', NULL, N'Y', N'', 4)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (56, 69, N'caller', N'来电', NULL, N'Y', N'', 1)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (57, 69, N'manual', N'手工', NULL, N'Y', N'', 2)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (58, 70, N'OAgent', N'普通坐席', NULL, N'Y', N'', 1)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (59, 70, N'LAgent', N'班长席', NULL, N'Y', N'', 2)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (60, 71, N'Y', N'可用', NULL, N'Y', N'', 1)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (61, 71, N'N', N'不可用', NULL, N'Y', N'', 2)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (62, 72, N'Batch', N'批量授权', NULL, N'Y', N'', 1)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (63, 72, N'Single', N'单机授权', NULL, N'Y', N'', 2)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (64, 73, N'Distribute', N'经销', NULL, N'Y', N'', 1)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (65, 73, N'DirectMark', N'直销', NULL, N'Y', N'', 2)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (66, 74, N'A', N'A', NULL, N'Y', N'', 1)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (67, 74, N'AA', N'AA', NULL, N'Y', N'', 2)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (68, 74, N'AAA', N'AAA', NULL, N'Y', N'', 3)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (69, 75, N'Ocust', N'普通客户', NULL, N'Y', N'', 1)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (70, 75, N'Lcust', N'大客户', NULL, N'Y', N'', 2)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (71, 75, N'VIPcust', N'VIP客户', NULL, N'Y', N'', 3)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (72, 76, N'EastChina', N'华东', NULL, N'Y', N'', 1)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (73, 76, N'NorthChina', N'华北', NULL, N'Y', N'', 2)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (74, 76, N'SouthChina', N'华南', NULL, N'Y', N'', 3)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (75, 76, N'Northeast', N'东北', NULL, N'Y', N'', 4)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (76, 76, N'Luyu', N'鲁豫', NULL, N'Y', N'', 5)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (77, 76, N'WestReason', N'西部', NULL, N'Y', N'', 6)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (78, 77, N'Nsyn', N'未同步', NULL, N'Y', N'', 1)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (79, 77, N'Ysyn', N'已同步', NULL, N'Y', N'', 2)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (80, 78, N'Ivr', N'IVR', NULL, N'Y', N'', 1)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (81, 78, N'Callin', N'坐席呼入', NULL, N'Y', N'', 2)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (82, 78, N'Callout', N'坐席呼出', NULL, N'Y', N'', 3)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (83, 78, N'LeaveMsg', N'留言', NULL, N'Y', N'', 4)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (84, 78, N'Qt', N'其他', NULL, N'Y', N'', 5)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (85, 79, N'login', N'登录中', NULL, N'Y', N'', 1)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (86, 79, N'logout', N'未登录', NULL, N'Y', N'', 2)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (87, 80, N'Y', N'是', NULL, N'Y', N'', 1)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (88, 80, N'N', N'否', NULL, N'Y', N'', 2)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (89, 81, N'=', N'=', NULL, N'Y', N'', 1)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (90, 81, N'>', N'>', NULL, N'Y', N'', 2)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (91, 81, N'>=', N'>=', NULL, N'Y', N'', 3)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (92, 81, N'<', N'<', NULL, N'Y', N'', 4)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (93, 81, N'<=', N'<=', NULL, N'Y', N'', 5)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (94, 82, N'A', N'A', NULL, N'Y', N'', 1)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (95, 82, N'AA', N'AA', NULL, N'Y', N'', 2)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (96, 82, N'AAA', N'AAA', NULL, N'Y', N'', 3)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (97, 82, N'Ocust', N'普通客户', NULL, N'Y', N'', 4)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (98, 82, N'Lcust', N'大客户', NULL, N'Y', N'', 5)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (99, 82, N'VIPcust', N'VIP客户', NULL, N'Y', N'', 6)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (136, 98, N'18910985096', N'梁', NULL, N'Y', N'', 0)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (101, 84, N'Y', N'是', NULL, N'Y', N'节假日', 1)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (102, 84, N'N', N'否', NULL, N'Y', N'工作日', 2)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (137, 99, N'18910985096', N'梁', NULL, N'Y', N'', 0)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (104, 85, N'09:00', N'09:00', NULL, N'Y', N'', 1)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (105, 85, N'10:00', N'10:00', NULL, N'Y', N'', 2)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (106, 85, N'11:00', N'10:00', NULL, N'Y', N'', 3)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (107, 85, N'12:00', N'12:00', NULL, N'Y', N'', 4)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (108, 85, N'13:00', N'13:00', NULL, N'Y', N'', 5)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (109, 85, N'14:00', N'14:00', NULL, N'Y', N'', 6)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (110, 85, N'15:00', N'15:00', NULL, N'Y', N'', 7)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (111, 85, N'16:00', N'16:00', NULL, N'Y', N'', 8)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (112, 85, N'17:00', N'17:00', NULL, N'Y', N'', 9)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (113, 85, N'18:00', N'18:00', NULL, N'Y', N'', 10)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (114, 86, N'1', N'外部呼叫', NULL, N'Y', N'', 1)
GO
print 'Processed 100 total records'
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (115, 86, N'2', N'内部呼叫', NULL, N'Y', N'', 2)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (116, 87, N'1', N'呼入', NULL, N'Y', N'', 1)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (117, 87, N'2', N'呼出', NULL, N'Y', N'', 2)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (118, 88, N'Male', N'男', NULL, N'Y', N'', 1)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (119, 88, N'Female', N'女', NULL, N'Y', N'', 2)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (140, 97, N'18910985096', N'梁', NULL, N'Y', N'', 0)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (142, 100, N'2', N'一般', NULL, N'Y', N'满意:1', 2)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (143, 100, N'3', N'不满意', NULL, N'Y', N'一般:2 满意:1', 3)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (134, 93, N'18910985096', N'梁', NULL, N'Y', N'', 0)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (135, 94, N'18910985096', N'梁', NULL, N'Y', N'', 0)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (138, 95, N'18910985096', N'梁', NULL, N'Y', N'', 0)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (141, 100, N'1', N'满意', NULL, N'Y', N'', 1)
INSERT [dbo].[bd_dictdetail] ([PK_DICTDETAIL], [PK_DICT], [CODE], [TITLE], [VALUE], [ISVALID], [REMARK], [DEFAULTORDER]) VALUES (139, 96, N'18910985096', N'梁', NULL, N'Y', N'', 0)
SET IDENTITY_INSERT [dbo].[bd_dictdetail] OFF
/****** Object:  Table [dbo].[bd_dict]    Script Date: 06/27/2013 11:34:09 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[bd_dict](
	[PK_DICT] [int] IDENTITY(1,1) NOT NULL,
	[DICTCODE] [varchar](20) NULL,
	[DICTTITLE] [varchar](20) NULL,
	[DICTTYPE] [varchar](20) NULL,
	[ISVALID] [varchar](10) NULL,
	[REMARK] [varchar](100) NULL,
	[TEMP] [varchar](100) NULL
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[bd_dict] ON
INSERT [dbo].[bd_dict] ([PK_DICT], [DICTCODE], [DICTTITLE], [DICTTYPE], [ISVALID], [REMARK], [TEMP]) VALUES (52, N'LOGTYPE', N'日志分类', NULL, N'Y', NULL, NULL)
INSERT [dbo].[bd_dict] ([PK_DICT], [DICTCODE], [DICTTITLE], [DICTTYPE], [ISVALID], [REMARK], [TEMP]) VALUES (55, N'CUSTOMER', N'客户', NULL, N'Y', NULL, NULL)
INSERT [dbo].[bd_dict] ([PK_DICT], [DICTCODE], [DICTTITLE], [DICTTYPE], [ISVALID], [REMARK], [TEMP]) VALUES (56, N'ORDERSTATUS', N'状态', NULL, N'Y', NULL, NULL)
INSERT [dbo].[bd_dict] ([PK_DICT], [DICTCODE], [DICTTITLE], [DICTTYPE], [ISVALID], [REMARK], [TEMP]) VALUES (60, N'OrderType', N'工单类型', NULL, N'Y', NULL, NULL)
INSERT [dbo].[bd_dict] ([PK_DICT], [DICTCODE], [DICTTITLE], [DICTTYPE], [ISVALID], [REMARK], [TEMP]) VALUES (61, N'Projecttype', N'项目类型', NULL, N'Y', NULL, NULL)
INSERT [dbo].[bd_dict] ([PK_DICT], [DICTCODE], [DICTTITLE], [DICTTYPE], [ISVALID], [REMARK], [TEMP]) VALUES (62, N'SourceOrder', N'工单来源', NULL, N'Y', NULL, NULL)
INSERT [dbo].[bd_dict] ([PK_DICT], [DICTCODE], [DICTTITLE], [DICTTYPE], [ISVALID], [REMARK], [TEMP]) VALUES (63, N'WorkOrderStatus', N'工单状态', NULL, N'Y', NULL, NULL)
INSERT [dbo].[bd_dict] ([PK_DICT], [DICTCODE], [DICTTITLE], [DICTTYPE], [ISVALID], [REMARK], [TEMP]) VALUES (64, N'Order', N'订单', NULL, N'Y', NULL, NULL)
INSERT [dbo].[bd_dict] ([PK_DICT], [DICTCODE], [DICTTITLE], [DICTTYPE], [ISVALID], [REMARK], [TEMP]) VALUES (65, N'CusinfoSource', N'客户信息来源', NULL, N'Y', NULL, NULL)
INSERT [dbo].[bd_dict] ([PK_DICT], [DICTCODE], [DICTTITLE], [DICTTYPE], [ISVALID], [REMARK], [TEMP]) VALUES (66, N'Sampletemplate', N'小样样板', NULL, N'Y', NULL, NULL)
INSERT [dbo].[bd_dict] ([PK_DICT], [DICTCODE], [DICTTITLE], [DICTTYPE], [ISVALID], [REMARK], [TEMP]) VALUES (67, N'Onsiteservice', N'现场服务', NULL, N'Y', NULL, NULL)
INSERT [dbo].[bd_dict] ([PK_DICT], [DICTCODE], [DICTTITLE], [DICTTYPE], [ISVALID], [REMARK], [TEMP]) VALUES (68, N'Complainthandling', N'投诉处理', NULL, N'Y', NULL, NULL)
INSERT [dbo].[bd_dict] ([PK_DICT], [DICTCODE], [DICTTITLE], [DICTTYPE], [ISVALID], [REMARK], [TEMP]) VALUES (69, N'GenerateMode', N'生成类型', NULL, N'Y', NULL, NULL)
INSERT [dbo].[bd_dict] ([PK_DICT], [DICTCODE], [DICTTITLE], [DICTTYPE], [ISVALID], [REMARK], [TEMP]) VALUES (70, N'AgentType', N'坐席类型', NULL, N'Y', NULL, NULL)
INSERT [dbo].[bd_dict] ([PK_DICT], [DICTCODE], [DICTTITLE], [DICTTYPE], [ISVALID], [REMARK], [TEMP]) VALUES (71, N'UserStatus', N'用户状态', NULL, N'Y', NULL, NULL)
INSERT [dbo].[bd_dict] ([PK_DICT], [DICTCODE], [DICTTITLE], [DICTTYPE], [ISVALID], [REMARK], [TEMP]) VALUES (72, N'AuthorizeType', N'授权方式', NULL, N'Y', NULL, NULL)
INSERT [dbo].[bd_dict] ([PK_DICT], [DICTCODE], [DICTTITLE], [DICTTYPE], [ISVALID], [REMARK], [TEMP]) VALUES (73, N'CustType1', N'客户分类一', NULL, N'Y', NULL, NULL)
INSERT [dbo].[bd_dict] ([PK_DICT], [DICTCODE], [DICTTITLE], [DICTTYPE], [ISVALID], [REMARK], [TEMP]) VALUES (74, N'Distribute', N'经销', NULL, N'Y', NULL, NULL)
INSERT [dbo].[bd_dict] ([PK_DICT], [DICTCODE], [DICTTITLE], [DICTTYPE], [ISVALID], [REMARK], [TEMP]) VALUES (75, N'DirectMark', N'直销', NULL, N'Y', NULL, NULL)
INSERT [dbo].[bd_dict] ([PK_DICT], [DICTCODE], [DICTTITLE], [DICTTYPE], [ISVALID], [REMARK], [TEMP]) VALUES (76, N'CustType3', N'客户分类三', NULL, N'Y', NULL, NULL)
INSERT [dbo].[bd_dict] ([PK_DICT], [DICTCODE], [DICTTITLE], [DICTTYPE], [ISVALID], [REMARK], [TEMP]) VALUES (77, N'SynStatus', N'同步状态', NULL, N'Y', NULL, NULL)
INSERT [dbo].[bd_dict] ([PK_DICT], [DICTCODE], [DICTTITLE], [DICTTYPE], [ISVALID], [REMARK], [TEMP]) VALUES (78, N'CallCreateType', N'创建类型', NULL, N'Y', NULL, NULL)
INSERT [dbo].[bd_dict] ([PK_DICT], [DICTCODE], [DICTTITLE], [DICTTYPE], [ISVALID], [REMARK], [TEMP]) VALUES (79, N'AgentStatus', N'当前状态', NULL, N'Y', NULL, NULL)
INSERT [dbo].[bd_dict] ([PK_DICT], [DICTCODE], [DICTTITLE], [DICTTYPE], [ISVALID], [REMARK], [TEMP]) VALUES (80, N'ISLost', N'是否呼损', NULL, N'Y', NULL, NULL)
INSERT [dbo].[bd_dict] ([PK_DICT], [DICTCODE], [DICTTITLE], [DICTTYPE], [ISVALID], [REMARK], [TEMP]) VALUES (81, N'Compare', N'比较符号', NULL, N'Y', NULL, NULL)
INSERT [dbo].[bd_dict] ([PK_DICT], [DICTCODE], [DICTTITLE], [DICTTYPE], [ISVALID], [REMARK], [TEMP]) VALUES (82, N'CustType2', N'客户分类二', NULL, N'Y', NULL, NULL)
INSERT [dbo].[bd_dict] ([PK_DICT], [DICTCODE], [DICTTITLE], [DICTTYPE], [ISVALID], [REMARK], [TEMP]) VALUES (83, N'QT', N'其他', NULL, N'Y', NULL, NULL)
INSERT [dbo].[bd_dict] ([PK_DICT], [DICTCODE], [DICTTITLE], [DICTTYPE], [ISVALID], [REMARK], [TEMP]) VALUES (84, N'WorkingCalendar', N'工作日历', NULL, N'Y', NULL, NULL)
INSERT [dbo].[bd_dict] ([PK_DICT], [DICTCODE], [DICTTITLE], [DICTTYPE], [ISVALID], [REMARK], [TEMP]) VALUES (85, N'RTime_day', N'报表时间-日', NULL, N'Y', NULL, NULL)
INSERT [dbo].[bd_dict] ([PK_DICT], [DICTCODE], [DICTTITLE], [DICTTYPE], [ISVALID], [REMARK], [TEMP]) VALUES (86, N'CallType', N'呼叫类型', NULL, N'Y', NULL, NULL)
INSERT [dbo].[bd_dict] ([PK_DICT], [DICTCODE], [DICTTITLE], [DICTTYPE], [ISVALID], [REMARK], [TEMP]) VALUES (87, N'CallDirection', N'呼叫方向', NULL, N'Y', NULL, NULL)
INSERT [dbo].[bd_dict] ([PK_DICT], [DICTCODE], [DICTTITLE], [DICTTYPE], [ISVALID], [REMARK], [TEMP]) VALUES (88, N'Gender', N'性别', NULL, N'Y', NULL, NULL)
INSERT [dbo].[bd_dict] ([PK_DICT], [DICTCODE], [DICTTITLE], [DICTTYPE], [ISVALID], [REMARK], [TEMP]) VALUES (93, N'0101', N'121购购订单处理', N'OnDuty', N'Y', N'梁:18910985096', N'18910985096')
INSERT [dbo].[bd_dict] ([PK_DICT], [DICTCODE], [DICTTITLE], [DICTTYPE], [ISVALID], [REMARK], [TEMP]) VALUES (94, N'0102', N'产品咨询', N'OnDuty', N'Y', N'梁:18910985096', N'18910985096')
INSERT [dbo].[bd_dict] ([PK_DICT], [DICTCODE], [DICTTITLE], [DICTTYPE], [ISVALID], [REMARK], [TEMP]) VALUES (98, N'0106', N'广告合作', N'OnDuty', N'Y', N'梁:18910985096', N'18910985096')
INSERT [dbo].[bd_dict] ([PK_DICT], [DICTCODE], [DICTTITLE], [DICTTYPE], [ISVALID], [REMARK], [TEMP]) VALUES (99, N'0107', N'投诉与建议', N'OnDuty', N'Y', N'梁:18910985096', N'18910985096')
INSERT [dbo].[bd_dict] ([PK_DICT], [DICTCODE], [DICTTITLE], [DICTTYPE], [ISVALID], [REMARK], [TEMP]) VALUES (100, N'StaCode', N'满意度', NULL, N'Y', NULL, NULL)
INSERT [dbo].[bd_dict] ([PK_DICT], [DICTCODE], [DICTTITLE], [DICTTYPE], [ISVALID], [REMARK], [TEMP]) VALUES (95, N'0103', N'大宗采购', N'OnDuty', N'Y', N'梁:18910985096', N'18910985096')
INSERT [dbo].[bd_dict] ([PK_DICT], [DICTCODE], [DICTTITLE], [DICTTYPE], [ISVALID], [REMARK], [TEMP]) VALUES (96, N'0105', N'售后服务', N'OnDuty', N'Y', N'梁:18910985096', N'18910985096')
INSERT [dbo].[bd_dict] ([PK_DICT], [DICTCODE], [DICTTITLE], [DICTTYPE], [ISVALID], [REMARK], [TEMP]) VALUES (97, N'0104', N'渠道合作', N'OnDuty', N'Y', N'梁:18910985096', N'18910985096')
SET IDENTITY_INSERT [dbo].[bd_dict] OFF
/****** Object:  Table [dbo].[AGENT_KPI_YEAR]    Script Date: 06/27/2013 11:34:09 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[AGENT_KPI_YEAR](
	[ID] [int] NOT NULL,
	[SKILL_ID] [varchar](40) NULL,
	[SKILL_DESC] [varchar](60) NULL,
	[STAT_TIME] [varchar](20) NULL,
	[TAIME] [varchar](20) NULL,
	[AGENT_ID] [varchar](40) NULL,
	[AGENT_NAME] [varchar](40) NULL,
	[ONLINE_TIME] [decimal](32, 0) NULL,
	[TAIKING_TIME] [decimal](32, 0) NULL,
	[WRAPUP_TIME] [decimal](32, 0) NULL,
	[HOLD_TIME] [decimal](32, 0) IDENTITY(1,1) NOT NULL,
	[IDLE_TIME] [decimal](32, 0) NULL,
	[REST_TIME] [decimal](32, 0) NULL,
	[OTHER_TIME] [decimal](32, 0) NULL,
	[ANSWER_NUM] [decimal](32, 0) NULL,
	[CALLOUT_NUM] [decimal](32, 0) NULL,
	[CALLOUT_SUCC_NUM] [decimal](32, 0) NULL,
	[TRANSF_NUM] [decimal](32, 0) NULL,
	[CONF_NUM] [decimal](32, 0) NULL,
	[HOLD_NUM] [decimal](32, 0) NULL,
	[WORK_LOAD] [decimal](32, 0) NULL,
	[AGENT_WORK_RATE] [decimal](32, 4) NULL,
	[AVG_TALKING_TIME] [decimal](32, 0) NULL
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[AGENT_KPI_MONTH]    Script Date: 06/27/2013 11:34:09 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[AGENT_KPI_MONTH](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[SKILL_ID] [varchar](40) NULL,
	[SKILL_DESC] [varchar](60) NULL,
	[STAT_TIME] [varchar](20) NULL,
	[TAIME] [varchar](20) NULL,
	[AGENT_ID] [varchar](40) NULL,
	[AGENT_NAME] [varchar](40) NULL,
	[ONLINE_TIME] [decimal](32, 0) NULL,
	[TAIKING_TIME] [decimal](32, 0) NULL,
	[WRAPUP_TIME] [decimal](32, 0) NULL,
	[HOLD_TIME] [decimal](32, 0) NULL,
	[IDLE_TIME] [decimal](32, 0) NULL,
	[REST_TIME] [decimal](32, 0) NULL,
	[OTHER_TIME] [decimal](32, 0) NULL,
	[ANSWER_NUM] [decimal](32, 0) NULL,
	[CALLOUT_NUM] [decimal](32, 0) NULL,
	[CALLOUT_SUCC_NUM] [decimal](32, 0) NULL,
	[TRANSF_NUM] [decimal](32, 0) NULL,
	[CONF_NUM] [decimal](32, 0) NULL,
	[HOLD_NUM] [decimal](32, 0) NULL,
	[WORK_LOAD] [decimal](32, 0) NULL,
	[AGENT_WORK_RATE] [decimal](32, 4) NULL,
	[AVG_TALKING_TIME] [decimal](32, 0) NULL
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[AGENT_KPI_DAY]    Script Date: 06/27/2013 11:34:09 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[AGENT_KPI_DAY](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[SKILL_ID] [varchar](40) NULL,
	[SKILL_DESC] [varchar](60) NULL,
	[STAT_TIME] [varchar](20) NULL,
	[TAIME] [varchar](20) NULL,
	[AGENT_ID] [varchar](40) NULL,
	[AGENT_NAME] [varchar](40) NULL,
	[ONLINE_TIME] [decimal](32, 0) NULL,
	[TAIKING_TIME] [decimal](32, 0) NULL,
	[WRAPUP_TIME] [decimal](32, 0) NULL,
	[HOLD_TIME] [decimal](32, 0) NULL,
	[IDLE_TIME] [decimal](32, 0) NULL,
	[REST_TIME] [decimal](32, 0) NULL,
	[OTHER_TIME] [decimal](32, 0) NULL,
	[ANSWER_NUM] [decimal](32, 0) NULL,
	[CALLOUT_NUM] [decimal](32, 0) NULL,
	[CALLOUT_SUCC_NUM] [decimal](32, 0) NULL,
	[TRANSF_NUM] [decimal](32, 0) NULL,
	[CONF_NUM] [decimal](32, 0) NULL,
	[HOLD_NUM] [decimal](32, 0) NULL,
	[WORK_LOAD] [decimal](32, 0) NULL,
	[AGENT_WORK_RATE] [decimal](32, 4) NULL,
	[AVG_TALKING_TIME] [decimal](32, 0) NULL
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[AGENT_CALL_LIST]    Script Date: 06/27/2013 11:34:09 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[AGENT_CALL_LIST](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[STAT_TIME] [varchar](20) NULL,
	[AGENT_ID] [varchar](40) NULL,
	[AGENT_NAME] [varchar](40) NULL,
	[SKILL_ID] [varchar](40) NULL,
	[SKILL_DESC] [varchar](60) NULL,
	[START_TIME] [varchar](50) NULL,
	[TALKING_TIME] [decimal](32, 0) NULL,
	[CALLER] [varchar](20) NULL,
	[CALLED] [varchar](20) NULL,
	[REC_PATH] [varchar](120) NULL,
	[DIRECTION] [decimal](2, 0) NULL,
	[CALLTYPE] [decimal](2, 0) NULL
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[AGENT_CALL_LIST] ON
SET IDENTITY_INSERT [dbo].[AGENT_CALL_LIST] OFF
