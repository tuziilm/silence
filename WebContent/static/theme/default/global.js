//for login
function checkLogin() {
	var username = $('[name="username"]').val();
	var passwd = $('[name="passwd"]').val();
	if (username == "") {
		$("#errors").html("����û�������û���!");
		return false;
	}
	if (passwd == "") {
		$("#errors").html("����û����������!");
		return false;
	}
	var request = $.ajax({
		type : "POST",
		url : "login",
		data : {
			"username" : username,
			"passwd" : passwd
		}
	});
	request.done(function(msg) {
		var result=eval(msg);
		if(result.success){
			location.href=location.href.substr(0,location.href.length-5);
		}else{
			$("#errors").html(result.msg);
		}
	});
	request.fail(function(msg) {
		$("#errors").html("��������æ�����Ժ�����!");
	});
	return false;
}
function showDetail(count,elem){
	$("#detail_"+count).toggle();
	$("i",elem).toggleClass(function (){
		if($(this).hasClass("icon-plus-sign")){
			return "icon-minus-sign";
		} else {
			return "icon-plus-sign";
		}
	});
}
//for some operations
function doOps(url,data){
	var request = $.ajax({
		type : "POST",
		url : $.trim(url),
		data : data
	});
	request.done(function(msg) {
		var result=eval(msg);
		if(result.success){
			gotoPage($("#paginator .active a").html());
		}else{
			alert("����ʧ�ܣ����Ժ����ԣ�");
		}
	});
	request.fail(function(msg) {
		alert("��������æ�����Ժ�����!");
	});
}
//-------form check-----------
function clearMsg(){
	$("#errors").html("");
	$("#msg").html("");
}
function empty(input){
	return $.trim(input.val())=="";
}
function required(input,msg){
	if($.trim(input.val())==""){
		$("#errors").append("<li>"+msg+"</li>");
		return false;
	}
	return true;
}
function notVal(input,val,msg){
	if($.trim(input.val())==val){
		$("#errors").append("<li>"+msg+"</li>");
		return false;
	}
	return true;
}
function greatThanlength(input,len,msg){
	if(input.val().length>len){
		$("#errors").append("<li>"+msg+"</li>");
		return false;
	}
	return true;
}
function notRange(input,min,max,msg){
	if(input.val().length>max || input.val().length<min){
		$("#errors").append("<li>"+msg+"</li>");
		return false;
	}
	return true;
}
function notIntValueRange(input,min,max,msg){
	var val=parseInt(input.val());
	if(val>max || val<min){
		$("#errors").append("<li>"+msg+"</li>");
		return false;
	}
	return true;
}
function checkSize(input, msg){
	if(!/^\d+\.?\d*[GgMmKk][Bb]$/.test(input.val())){
		$("#errors").append("<li>"+msg+"</li>");
		return false;
	}
	return true;
}
function checkFreqency(input, msg){
	if(!/^\d+\.?\d*[GgMmKk]?[Hh][Zz]$/.test(input.val())){
		$("#errors").append("<li>"+msg+"</li>");
		return false;
	}
	return true;
}
function checkVersion(input, msg){
	if(!/^\d+(\.\d+){0,2}$/.test(input.val())){
		$("#errors").append("<li>"+msg+"</li>");
		return false;
	}
	return true;
}
function checkAllDigits(input, msg){
	if(!/^\d+$/.test(input.val())){
		$("#errors").append("<li>"+msg+"</li>");
		return false;
	}
	return true;
}
function checkUrl(input, msg){
	if(!/^https?:\/\/(\w+\.)+\w+(:\d{2,5})?(\/.*)?$/.test(input.val())){
		$("#errors").append("<li>"+msg+"</li>");
		return false;
	}
	return true;
}
//------channel form ---------
function onSubmitChannelForm(form){
	var ctx=$(form);
	clearMsg();
	var pass=required($("input[name='name']",ctx), "�������Ʋ���Ϊ��");
	//var a=input.attr("name");
	pass=pass&&notRange($("input[name='name']",ctx), 1, 20, "�������Ƴ���Ӧ��1~20���ַ�");
	
	pass=pass&&checkAllDigits($("input[name='shareProportion']",ctx), "�ֳɱ�������Ϊ�գ���ֻ����������");
	pass=pass&&notIntValueRange($("input[name='shareProportion']",ctx), 0, 100, "�ֳɱ�����Χ0~100");
	
	pass=pass&&checkAllDigits($("input[name='hiddenProportion']",ctx), "�����������Ϊ�գ���ֻ����������");
	pass=pass&&notIntValueRange($("input[name='hiddenProportion']",ctx), 0, 100, "���������Χ0~100");
	return pass;
}
//------client form ---------
function onSubmitClientForm(form){
	var ctx=$(form);
	clearMsg();
	var pass=checkAllDigits($("input[name='channelHiddenProportion']",ctx), "������������Ϊ�գ���ֻ����������");
	pass=pass&&notIntValueRange($("input[name='channelHiddenProportion']",ctx), 0, 100, "����������Χ0~100");
	
	pass=pass&&checkAllDigits($("input[name='monthLimit']",ctx), "���޶��Ϊ�գ���ֻ����������");
	pass=pass&&notIntValueRange($("input[name='monthLimit']",ctx), 0, 10000, "���޶Χ0~10000");
	return pass;
}
//------sp_channel form ---------
function onSubmitSpChannelForm(form){
	var ctx=$(form);
	clearMsg();
	var pass=required($("input[name='name']",ctx), "ͨ�����Ʋ���Ϊ��");
	pass=pass&&notRange($("input[name='name']",ctx), 1, 100, "ͨ�����Ƴ���Ӧ��1~100���ַ�");
	
	pass=pass&&required($("select[name='company']",ctx), "���빫˾������Ϊ��");
	pass=pass&&notRange($("select[name='company']",ctx), 1, 20, "���빫˾������Ӧ��1~20���ַ�");
	
	pass=pass&&checkAllDigits($("input[name='totalDayLimit']",ctx), "�����޶��Ϊ�գ���ֻ����������");
	pass=pass&&notIntValueRange($("input[name='totalDayLimit']",ctx), 0, 10000, "�����޶Χ0~10000");
	
	pass=pass&&checkAllDigits($("input[name='userDayLimit']",ctx), "���û����޶��Ϊ�գ���ֻ����������");
	pass=pass&&notIntValueRange($("input[name='userDayLimit']",ctx), 0, 10000, "���û����޶Χ0~10000");
	
	pass=pass&&checkAllDigits($("input[name='userMonthLimit']",ctx), "���û����޶��Ϊ�գ���ֻ����������");
	pass=pass&&notIntValueRange($("input[name='userMonthLimit']",ctx), 0, 10000, "���û����޶Χ0~10000");
	
	pass=pass&&checkAllDigits($("input[name='fee']",ctx), "ҵ���ʷѲ���Ϊ�գ���ֻ����������");
	pass=pass&&notIntValueRange($("input[name='fee']",ctx), 0, 1000000, "ҵ���ʷѷ�Χ0~1000000");
	
	pass=pass&&checkAllDigits($("input[name='settlementPrice']",ctx), "����۸���Ϊ�գ���ֻ����������");
	pass=pass&&notIntValueRange($("input[name='settlementPrice']",ctx), 0, 1000000, "����۸�Χ0~1000000");
	
	pass=pass&&required($("input[name='instruction']",ctx), "ָ���Ϊ��");
	pass=pass&&notRange($("input[name='instruction']",ctx), 1, 100, "ָ���Ӧ��1~100���ַ�");
	
	pass=pass&&required($("input[name='port']",ctx), "�˿ڲ���Ϊ��");
	pass=pass&&notRange($("input[name='port']",ctx), 1, 20, "�˿ڳ���Ӧ��1~20���ַ�");
	
	pass=pass&&required($("input[name='serverIp']",ctx), "SP������IP����Ϊ��");
	pass=pass&&checkUrl($("input[name='serverIp']",ctx),"SP������IP��ʽ����ȷ������http://zhanghui.com");
	return pass;
}
//------product form ---------
function onSubmitProductForm(form){
	var ctx=$(form);
	clearMsg();
	var pass=required($("input[name='name']",ctx),"��Ʒ���Ʋ���Ϊ�գ�");
	pass=pass&&notRange($("input[name='name']",ctx), 1, 20, "��Ʒ���Ƴ���Ӧ��1~20���ַ�");
	
	pass=pass&&required($("input[name='pricePointId']",ctx), "�ԽӼƷѲ�ƷID����Ϊ��");
	pass=pass&&notRange($("input[name='pricePointId']",ctx), 1, 20, "�ԽӼƷѲ�ƷID����Ӧ��1~20���ַ�");
	return pass;
}
//------product_mt form ---------
function onSubmitProductMtForm(form){
	var ctx=$(form);
	clearMsg();
	
	var pass=required($("select[name='pricePointId']",ctx), "�ԽӼƷѲ�ƷID����Ϊ��");
	pass=pass&&notRange($("select[name='pricePointId']",ctx), 1, 20, "�ԽӼƷѲ�ƷID����Ӧ��1~20���ַ�");
	
	pass=pass&&required($("input[name='mtInfo']",ctx), "MT��Ϣ����Ϊ��");
	pass=pass&&notRange($("input[name='mtInfo']",ctx), 1, 1000, "MT��Ϣ����Ӧ��1~1000���ַ�");
	return pass;
}




//------app_adv form ---------
function onSubmitAppAdvForm(form){
	var ctx=$(form);
	clearMsg();
	var pass=required($("input[name='appName']",ctx),"Ӧ�����Ʋ���Ϊ�գ�");
	pass=pass&&notRange($("input[name='appName']",ctx),1,100,"Ӧ�����Ƴ���Ӧ����1-100���ַ���");
	if(isNaN(parseInt($("input[name='id']",ctx).val()))){
		pass=pass&&required($("input[name='file']",ctx),"Ӧ���ļ�����Ϊ�գ�");
	}
	pass=pass&&notVal($("select[name='appTypeId']",ctx),-1,"Ӧ�����Ͳ���Ϊ�գ�");
	pass=pass&&notVal($("select[name='advTypeId']",ctx),-1,"������Ͳ���Ϊ�գ�");
	pass=pass&&notVal($("select[name='settlementTypeId']",ctx),-1,"�������Ͳ���Ϊ�գ�");
	
	pass=pass&&greatThanlength($("textarea[name='desc']",ctx),1000,"Ӧ�ý��ܳ��Ȳ��ܳ���1000���ַ���");
	
	pass=pass&&(empty($("input[name='cpuSpeed']",ctx))||checkFreqency($("input[name='cpuSpeed']",ctx),"CPU�ٶȸ�ʽ����ȷ��ӦΪxxGHZ/MHZ/KHZ/HZ��"));
	pass=pass&&(empty($("input[name='ramSize']",ctx))||checkSize($("input[name='ramSize']",ctx),"RAM������ʽ����ȷ��ӦΪxxGB/MB/KB��"));
	pass=pass&&(empty($("input[name='romSize']",ctx))||checkSize($("input[name='romSize']",ctx),"ROM������ʽ����ȷ��ӦΪxxGB/MB/KB��"));
	pass=pass&&(empty($("input[name='sdSize']",ctx))||checkSize($("input[name='sdSize']",ctx),"SD��������ʽ����ȷ��ӦΪxxGB/MB/KB��"));
	pass=pass&&(empty($("input[name='gpuVer']",ctx))||checkVersion($("input[name='gpuVer']",ctx),"GPU�汾�汾�Ÿ�ʽ����ȷ��ӦΪx.x.x���磺4.0.3��"));
	pass=pass&&(empty($("input[name='androidVer']",ctx))||checkVersion($("input[name='androidVer']",ctx),"��׿ϵͳ�汾�Ÿ�ʽ����ȷ��ӦΪx.x.x���磺4.0.3��"));
	pass=pass&&(empty($("input[name='androidCoreVer']",ctx))||checkVersion($("input[name='androidCoreVer']",ctx),"��׿�ں˰汾�Ÿ�ʽ����ȷ��ӦΪx.x.x���磺4.0.3��"));
	return pass;
}
//-------brand or other adv form ----------
function onSubmitBrandOrOtherAdvForm(form){
	var ctx=$(form);
	clearMsg();
	var pass=required($("input[name='advName']",ctx),"������Ʋ���Ϊ�գ�");
	pass=pass&&notRange($("input[name='advName']",ctx),1,100,"������Ƴ���Ӧ����1-100���ַ���");
	
	if(document.getElementsByName("advCatalog")[0].checked){//Ʒ�ƹ��
		if($("input[name='file']",ctx).val()=="" && $("input[name='advFileName']",ctx).val()==""){
			$("#errors").append("<li>����ļ�����Ϊ�գ�</li>");
			pass=pass&&false;
		}
	}else{//�������
		if($("input[name='url']",ctx).val()==""){
			$("#errors").append("<li>����������Ӳ���Ϊ�գ�</li>");
			pass=pass&&false;
		}else{
			pass=pass&&checkUrl($("input[name='url']",ctx),"����������Ӹ�ʽ����ȷ��");
		}
	}
	
	pass=pass&&notVal($("select[name='promoteTypeId']",ctx),-1,"�ƹ����Ͳ���Ϊ�գ�");
	pass=pass&&notVal($("select[name='advTypeId']",ctx),-1,"������Ͳ���Ϊ�գ�");
	pass=pass&&notVal($("select[name='settlementTypeId']",ctx),-1,"�������Ͳ���Ϊ�գ�");
	
	pass=pass&&greatThanlength($("textarea[name='desc']",ctx),1000,"����������Ȳ��ܳ���1000���ַ���");
	return pass;
}
//-------config form ----------
function onSubmitConfigForm(form){
	var ctx=$(form);
	clearMsg();
	var pass=checkAllDigits($("input[name='advFrequency']",ctx),"���չʾƵ�ʲ���Ϊ�գ���Ӧ��������ɣ�");
	pass=pass&&notIntValueRange($("input[name='advFrequency']",ctx),1,1000,"���չʾƵ��Ӧ����[1,1000]��Χ֮��!");
	pass=pass&&checkAllDigits($("input[name='advSmsNumber']",ctx),"Ĭ�϶��ŷ��ͺ��벻��Ϊ�գ���Ӧ��������ɣ�");
	return pass;
}
//-------uLifeUrl form ----------
function onSubmitULifeUrlForm(form){
	var ctx=$(form);
	clearMsg();
	var pass=required($("input[name='module']",ctx),"ģ�����Ʋ���Ϊ�գ�");
	pass=pass&&notRange($("input[name='module']",ctx),1,40,"ģ�����Ƴ���Ӧ����40���ַ����ڣ�");
	var pass=required($("input[name='url']",ctx),"���Ӳ���Ϊ�գ�");
	pass=pass&&notRange($("input[name='url']",ctx),1,500,"���ӳ���Ӧ����500���ַ����ڣ�");
	pass=pass&&checkUrl($("input[name='url']",ctx),"���Ӹ�ʽ����ȷ��");
	return pass;
}
//-------uLifeAdv form ----------
function onSubmitULifeAdvForm(form){
	var ctx=$(form);
	clearMsg();
	var pass=required($("input[name='module']",ctx),"ģ�����Ʋ���Ϊ�գ�");
	pass=pass&&notRange($("input[name='module']",ctx),1,40,"ģ�����Ƴ���Ӧ����40���ַ����ڣ�");
	$("input[name=mediaPath]").each(
		function(idx,elem){
			elem=$(elem);
			if(elem.val()=="") 
				elem.parent().remove();
		}
	);
	return pass;
}