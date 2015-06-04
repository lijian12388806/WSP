--数据字典
--工单类型
INSERT INTO bd_dict(PK_DICT,DICTCODE,DICTTITLE,DICTTYPE,ISVALID) VALUES ('60','OrderType','工单类型','YW','Y');

INSERT INTO bd_dictdetail(PK_DICT,CODE,TITLE,ISVALID) VALUES ('60','Sampledependence','小样依赖','Y');
INSERT INTO bd_dictdetail(PK_DICT,CODE,TITLE,ISVALID) VALUES ('60','Amodeldependent','样板依赖','Y');
INSERT INTO bd_dictdetail(PK_DICT,CODE,TITLE,ISVALID) VALUES ('60','SampleRequest','样板需求','Y');
INSERT INTO bd_dictdetail(PK_DICT,CODE,TITLE,ISVALID) VALUES ('60','OrderDelivery','订单交货','Y');
INSERT INTO bd_dictdetail(PK_DICT,CODE,TITLE,ISVALID) VALUES ('60','Onsiteservice','现场服务','Y');
INSERT INTO bd_dictdetail(PK_DICT,CODE,TITLE,ISVALID) VALUES ('60','Complainthandling','投诉受理','Y');
INSERT INTO bd_dictdetail(PK_DICT,CODE,TITLE,ISVALID) VALUES ('60','ReturnRequest','退货申请','Y');



--项目类型

INSERT INTO bd_dict(PK_DICT,DICTCODE,DICTTITLE,DICTTYPE,ISVALID) VALUES ('61','Projecttype','项目类型','YW','Y');

INSERT INTO bd_dictdetail(PK_DICT,CODE,TITLE,ISVALID) VALUES ('61','Order','订单','Y');
INSERT INTO bd_dictdetail(PK_DICT,CODE,TITLE,ISVALID) VALUES ('61','Sampletemplate','小样样板','Y');
INSERT INTO bd_dictdetail(PK_DICT,CODE,TITLE,ISVALID) VALUES ('61','Onsiteservice','现场服务','Y');
INSERT INTO bd_dictdetail(PK_DICT,CODE,TITLE,ISVALID) VALUES ('61','Complainthandling','投诉处理','Y');


--工单来源
INSERT INTO bd_dict(PK_DICT,DICTCODE,DICTTITLE,DICTTYPE,ISVALID) VALUES ('62','SourceOrder','工单来源','YW','Y');

INSERT INTO bd_dictdetail(PK_DICT,CODE,TITLE,ISVALID) VALUES ('62','customer','客户','Y');
INSERT INTO bd_dictdetail(PK_DICT,CODE,TITLE,ISVALID) VALUES ('62','sell','销售','Y');

--工单状态

INSERT INTO bd_dict(PK_DICT,DICTCODE,DICTTITLE,DICTTYPE,ISVALID) VALUES ('63','WorkOrderStatus','工单状态','YW','Y');

INSERT INTO bd_dictdetail(PK_DICT,CODE,TITLE,ISVALID) VALUES ('63','wcl','未处理','Y');
INSERT INTO bd_dictdetail(PK_DICT,CODE,TITLE,ISVALID) VALUES ('63','dhxcl','待后续处理','Y');
INSERT INTO bd_dictdetail(PK_DICT,CODE,TITLE,ISVALID) VALUES ('63','ywc','已完成','Y');
INSERT INTO bd_dictdetail(PK_DICT,CODE,TITLE,ISVALID) VALUES ('63','yjd','已结单','Y');

--订单
INSERT INTO bd_dict(PK_DICT,DICTCODE,DICTTITLE,DICTTYPE,ISVALID) VALUES ('64','Order','订单','YW','Y');

INSERT INTO bd_dictdetail(PK_DICT,CODE,TITLE,ISVALID) VALUES ('64','ylsycyc','依赖书延迟异常','Y');
INSERT INTO bd_dictdetail(PK_DICT,CODE,TITLE,ISVALID) VALUES ('64','wlwhycyc','物料维护延迟异常','Y');
INSERT INTO bd_dictdetail(PK_DICT,CODE,TITLE,ISVALID) VALUES ('64','ddycyc','订单延迟异常','Y');
INSERT INTO bd_dictdetail(PK_DICT,CODE,TITLE,ISVALID) VALUES ('64','wljhyc','物流交货异常','Y');
INSERT INTO bd_dictdetail(PK_DICT,CODE,TITLE,ISVALID) VALUES ('64','ddjdyc','订单进度的查询','Y');

--客户信息来源
INSERT INTO bd_dict(PK_DICT,DICTCODE,DICTTITLE,DICTTYPE,ISVALID) VALUES ('65','CusinfoSource','客户信息来源','YW','Y');

INSERT INTO bd_dictdetail(PK_DICT,CODE,TITLE,ISVALID) VALUES ('65','byhand','手工创建','Y');
INSERT INTO bd_dictdetail(PK_DICT,CODE,TITLE,ISVALID) VALUES ('65','datesyn','资料同步','Y');

--小样样板
INSERT INTO bd_dict(PK_DICT,DICTCODE,DICTTITLE,DICTTYPE,ISVALID) VALUES ('66','Sampletemplate','小样样板','YW','Y');

INSERT INTO bd_dictdetail(PK_DICT,CODE,TITLE,ISVALID) VALUES ('66','S_delayExc','小样、样板延迟异常','Y');
INSERT INTO bd_dictdetail(PK_DICT,CODE,TITLE,ISVALID) VALUES ('66','S_repeatExc','小样、样板重复异常','Y');
INSERT INTO bd_dictdetail(PK_DICT,CODE,TITLE,ISVALID) VALUES ('66','S_majorMeet','重大项目的满足','Y');
INSERT INTO bd_dictdetail(PK_DICT,CODE,TITLE,ISVALID) VALUES ('66','S_progressQuery','进度的查询','Y');

--现场服务
INSERT INTO bd_dict(PK_DICT,DICTCODE,DICTTITLE,DICTTYPE,ISVALID) VALUES ('67','Onsiteservice','现场服务','YW','Y');

INSERT INTO bd_dictdetail(PK_DICT,CODE,TITLE,ISVALID) VALUES ('67','On_serviceDispatch','服务人员对重大项目和特大项目的调配（调动大区、战略客户、应用管理部的全国资源）','Y');
INSERT INTO bd_dictdetail(PK_DICT,CODE,TITLE,ISVALID) VALUES ('67','On_sampleDispatch','对重大项目和特大项目的样漆/样板/现场试刷/样板楼的人员分配','Y');
INSERT INTO bd_dictdetail(PK_DICT,CODE,TITLE,ISVALID) VALUES ('67','On_specialDisplay','对特殊效果和产品的调样，样板的工厂间分配','Y');

--投诉处理
INSERT INTO bd_dict(PK_DICT,DICTCODE,DICTTITLE,DICTTYPE,ISVALID) VALUES ('68','Complainthandling','投诉处理','YW','Y');

INSERT INTO bd_dictdetail(PK_DICT,CODE,TITLE,ISVALID) VALUES ('68','C_ComplaintsExc','投诉退货、换货异常','Y');
INSERT INTO bd_dictdetail(PK_DICT,CODE,TITLE,ISVALID) VALUES ('68','C_compensateExc','样品赔偿异常','Y');
INSERT INTO bd_dictdetail(PK_DICT,CODE,TITLE,ISVALID) VALUES ('68','C_produceExc','换货生产异常','Y');
INSERT INTO bd_dictdetail(PK_DICT,CODE,TITLE,ISVALID) VALUES ('68','C_cchedule','进度查询','Y');

--生成类型
INSERT INTO bd_dict(PK_DICT,DICTCODE,DICTTITLE,DICTTYPE,ISVALID) VALUES ('69','GenerateMode','生成类型','YW','Y');

INSERT INTO bd_dictdetail(PK_DICT,CODE,TITLE,ISVALID) VALUES ('69','caller','来电','Y');
INSERT INTO bd_dictdetail(PK_DICT,CODE,TITLE,ISVALID) VALUES ('69','manual','手工','Y');

--坐席类型
INSERT INTO bd_dict(PK_DICT,DICTCODE,DICTTITLE,DICTTYPE,ISVALID) VALUES ('70','AgentType','坐席类型','YW','Y');

INSERT INTO bd_dictdetail(PK_DICT,CODE,TITLE,ISVALID) VALUES ('70','OAgent','普通坐席','Y');
INSERT INTO bd_dictdetail(PK_DICT,CODE,TITLE,ISVALID) VALUES ('70','LAgent','班长席','Y');

--用户状态
INSERT INTO bd_dict(PK_DICT,DICTCODE,DICTTITLE,DICTTYPE,ISVALID) VALUES ('71','AgentType','用户状态','YW','Y');

INSERT INTO bd_dictdetail(PK_DICT,CODE,TITLE,ISVALID) VALUES ('71','Y','可用','Y');
INSERT INTO bd_dictdetail(PK_DICT,CODE,TITLE,ISVALID) VALUES ('71','N','不可用','Y');

--授权方式
INSERT INTO bd_dict(PK_DICT,DICTCODE,DICTTITLE,DICTTYPE,ISVALID) VALUES ('72','AuthorizeType','授权方式','YW','Y');

INSERT INTO bd_dictdetail(PK_DICT,CODE,TITLE,ISVALID) VALUES ('72','Batch','批量授权','Y');
INSERT INTO bd_dictdetail(PK_DICT,CODE,TITLE,ISVALID) VALUES ('72','Single','单机授权','Y');

--客户分类一
INSERT INTO bd_dict(PK_DICT,DICTCODE,DICTTITLE,DICTTYPE,ISVALID) VALUES ('73','CustType1','客户分类一','YW','Y');

INSERT INTO bd_dictdetail(PK_DICT,CODE,TITLE,ISVALID) VALUES ('73','Distribute','经销','Y');
INSERT INTO bd_dictdetail(PK_DICT,CODE,TITLE,ISVALID) VALUES ('73','DirectMark','直销','Y');

--经销
INSERT INTO bd_dict(PK_DICT,DICTCODE,DICTTITLE,DICTTYPE,ISVALID) VALUES ('74','Distribute','经销','YW','Y');

INSERT INTO bd_dictdetail(PK_DICT,CODE,TITLE,ISVALID) VALUES ('74','A','A','Y');
INSERT INTO bd_dictdetail(PK_DICT,CODE,TITLE,ISVALID) VALUES ('74','AA','AA','Y');
INSERT INTO bd_dictdetail(PK_DICT,CODE,TITLE,ISVALID) VALUES ('74','AAA','AAA','Y');

--直销
INSERT INTO bd_dict(PK_DICT,DICTCODE,DICTTITLE,DICTTYPE,ISVALID) VALUES ('75','DirectMark','直销','YW','Y');

INSERT INTO bd_dictdetail(PK_DICT,CODE,TITLE,ISVALID) VALUES ('75','Ocust','普通客户','Y');
INSERT INTO bd_dictdetail(PK_DICT,CODE,TITLE,ISVALID) VALUES ('75','Lcust','大客户','Y');
INSERT INTO bd_dictdetail(PK_DICT,CODE,TITLE,ISVALID) VALUES ('75','VIPcust','VIP客户','Y');

--客户分类三
INSERT INTO bd_dict(PK_DICT,DICTCODE,DICTTITLE,DICTTYPE,ISVALID) VALUES ('76','CustType3','客户分类三','YW','Y');

INSERT INTO bd_dictdetail(PK_DICT,CODE,TITLE,ISVALID) VALUES ('76','EastChina','华东','Y');
INSERT INTO bd_dictdetail(PK_DICT,CODE,TITLE,ISVALID) VALUES ('76','NorthChina','华北','Y');
INSERT INTO bd_dictdetail(PK_DICT,CODE,TITLE,ISVALID) VALUES ('76','SouthChina','华南','Y');
INSERT INTO bd_dictdetail(PK_DICT,CODE,TITLE,ISVALID) VALUES ('76','Northeast','东北','Y');
INSERT INTO bd_dictdetail(PK_DICT,CODE,TITLE,ISVALID) VALUES ('76','Luyu','鲁豫','Y');
INSERT INTO bd_dictdetail(PK_DICT,CODE,TITLE,ISVALID) VALUES ('76','WestReason','西部','Y');