$(function(){
	$tree_size=0;
	/*zTree*/
	var setting = {
		edit: {
			drag: {
				autoExpandTrigger: true,
				prev: dropPrev,
				inner: dropInner,
				next: dropNext
			},
			enable: true,
			showRemoveBtn: false,
			showRenameBtn: false
		},
		view:{
			showLine:false,
			showIcon:true
		},
		data: {
			simpleData: {
				enable: true
			},
			keep:{
				parent:true
			}
		},
		callback: {
			beforeDrag: beforeDrag,
			beforeDrop: beforeDrop,
			beforeDragOpen: beforeDragOpen,
			onDrag: onDrag,
			onDrop: onDrop,
			onExpand: onExpand
		}
	};
	var data=[
		{id:1,pId:0,name:"正卷",open:true,drag:false,isParent:true,dropInner:false},
		{id:11,pId:1,name:"立案审批表(0)",drag:false,isParent:true},
		{id:12,pId:1,name:"起诉状、上诉状、抗诉书、案件移送函等表明案件来源的材料(0)",drag:false,isParent:true},
		{id:13,pId:1,name:"原审人民法院裁判文书(0)",drag:false,isParent:true},
		{id:14,pId:1,name:"受理通知书、应诉通知书及送达回证或者其他送达凭证(0)",drag:false,isParent:true},
		{id:15,pId:1,name:"答辩状及送达回证或者其他送达凭证(0)",drag:false,isParent:true},
		{id:16,pId:1,name:"诉讼费收取手续(0)",drag:false,isParent:true},
		{id:17,pId:1,name:"送卷函、调卷函(0)",drag:false,isParent:true},
		{id:18,pId:1,name:"当事人身份证明、授权委托书(0)",drag:false,isParent:true},
		{id:19,pId:1,name:"调查、询问、讯问笔录、调查取证材料(0)",drag:false,isParent:true},
		{id:10,pId:1,name:"当事人提供的证据材料(0)",drag:false,isParent:true},
		{id:111,pId:1,name:"诉前保全、财产保全材料(0)",drag:false,isParent:true},
		{id:112,pId:1,name:"司法裁定材料(0)",drag:false,isParent:true},
		{id:113,pId:1,name:"传票、提押票(0)",drag:false,isParent:true},
		{id:114,pId:1,name:"开庭通知、公告、庭审笔录(0)",drag:false,isParent:true},
		{id:115,pId:1,name:"代理词、辩护词、被告人陈述词(0)",drag:false,isParent:true},
		{id:116,pId:1,name:"延长审理期限审批表(0)",drag:false,isParent:true},
		{id:117,pId:1,name:"撤诉书(0)",drag:false,isParent:true},
		{id:118,pId:1,name:"判决书、裁定书、调解书、决定书、司法建议书和其他法律文书正本及送达回证或者其他送达凭证(0)",drag:false,isParent:true},
		{id:119,pId:1,name:"宣判公告、宣判笔录、委托宣判函(0)",drag:false,isParent:true},
		{id:120,pId:1,name:"死刑执行命令(0)",drag:false,isParent:true},
		{id:121,pId:1,name:"物证处理材料(0)",drag:false,isParent:true},
		{id:122,pId:1,name:"妨碍诉讼的强制措施材料(0)",drag:false,isParent:true},
		{id:123,pId:1,name:"民事、行政执行材料(0)",drag:false,isParent:true},
		{id:124,pId:1,name:"案件移送函存根、退卷函、退卷函存根、上级人民法院裁判文书正本(0)",drag:false,isParent:true},
		{id:125,pId:1,name:"其他诉讼文书材料(0)",drag:false,isParent:true},

		{id:2,pId:0,name:"副卷",open:true,drag:false,isParent:true,dropInner:false},
		{id:21,pId:2,name:"阅卷笔录(0)",drag:false,isParent:true},
		{id:22,pId:2,name:"案件审理报告(0)",drag:false,isParent:true},
		{id:23,pId:2,name:"合议庭评议案件笔录(0)",drag:false,isParent:true},
		{id:24,pId:2,name:"审判委员会讨论案件记录(0)",drag:false,isParent:true},
		{id:25,pId:2,name:"延长审理期限的申请和批示材料(0)",drag:false,isParent:true},
		{id:26,pId:2,name:"判决书、裁定书、调解书、决定书、司法建议书和其他法律文书原本(0)",drag:false,isParent:true},
		{id:27,pId:2,name:"执行死刑照片和其他执行死刑材料(0)",drag:false,isParent:true},
		{id:28,pId:2,name:"其他不宜对外公开的材料(0)",drag:false,isParent:true}
	];
	function dropPrev(treeId, nodes, targetNode) {
		var pNode = targetNode.getParentNode();
		if (pNode && pNode.dropInner === false) {
			return false;
		} else {
			for (var i=0,l=curDragNodes.length; i<l; i++) {
				var curPNode = curDragNodes[i].getParentNode();
				if (curPNode && curPNode !== targetNode.getParentNode() && curPNode.childOuter === false) {
					return false;
				}
			}
		}
		return true;
	}
	function dropInner(treeId, nodes, targetNode) {
		if (targetNode && targetNode.dropInner === false) {
			return false;
		} else {
			for (var i=0,l=curDragNodes.length; i<l; i++) {
				if (!targetNode && curDragNodes[i].dropRoot === false) {
					return false;
				} else if (curDragNodes[i].parentTId && curDragNodes[i].getParentNode() !== targetNode && curDragNodes[i].getParentNode().childOuter === false) {
					return false;
				}
			}
		}
		return true;
	}
	function dropNext(treeId, nodes, targetNode) {
		var pNode = targetNode.getParentNode();
		if (pNode && pNode.dropInner === false) {
			return false;
		} else {
			for (var i=0,l=curDragNodes.length; i<l; i++) {
				var curPNode = curDragNodes[i].getParentNode();
				if (curPNode && curPNode !== targetNode.getParentNode() && curPNode.childOuter === false) {
					return false;
				}
			}
		}
		return true;
	}

	var log, className = "dark", curDragNodes, autoExpandNode;
	function beforeDrag(treeId, treeNodes) {
		className = (className === "dark" ? "":"dark");
		for (var i=0,l=treeNodes.length; i<l; i++) {
			if (treeNodes[i].drag === false) {
				curDragNodes = null;
				return false;
			} else if (treeNodes[i].parentTId && treeNodes[i].getParentNode().childDrag === false) {
				curDragNodes = null;
				return false;
			}
		}
		curDragNodes = treeNodes;
		return true;
	}
	function beforeDragOpen(treeId, treeNode) {
		autoExpandNode = treeNode;
		return true;
	}
	function beforeDrop(treeId, treeNodes, targetNode, moveType, isCopy) {
		className = (className === "dark" ? "":"dark");
		if(targetNode.level==0)
			return false;
		return true;
	}
	function onDrag(event, treeId, treeNodes) {
		className = (className === "dark" ? "":"dark");
	}
	function onDrop(event, treeId, treeNodes, targetNode, moveType, isCopy) {
		className = (className === "dark" ? "":"dark");
		updateType();
	}
	function onExpand(event, treeId, treeNode) {
		if (treeNode === autoExpandNode) {
			className = (className === "dark" ? "":"dark");
		}
	}
	function updateType() {
		var zTree = $.fn.zTree.getZTreeObj("tree_index");
		var nodes = zTree.getNodesByParam("level","1");
		for (var i=0, l=nodes.length; i<l; i++) {
			var num = nodes[i].children ? nodes[i].children.length : 0;
			nodes[i].name = nodes[i].name.split("(")[0]+"("+num+")";
			zTree.updateNode(nodes[i]);
		}
	}
	function amountAdd(node,tree){
		var selections=$(".plupload_file").has($(".plupload_file_checkInput:checked").not(".check_invisible"));
		if(selections.length!=2){
			alert("请选择批量添加的图片起始位置和结束位置");
			return;
		}
		var s_arr=[];
		var s_begin=$(selections.get(0));
		var s_end=$(selections.get(1));
		s_arr.push(s_begin);
		var next_node=s_begin.next();
		while(next_node){
			s_arr.push(next_node);
			if(next_node.prop("id")!=s_end.prop("id")){
				next_node=next_node.next();
			}else{
				next_node=false;
			}
		}
		if(node.check_Child_State==-1)
			$tree_size=0;
		else
			$tree_size=node.children.length;
		for(var i=0;i<s_arr.length;i++){
			var value=s_arr[i].find(".plupload_file_namespan").text();
			$tree_size +=1;
			treeNode = tree.addNodes(node, {id:(node.id*10 + $tree_size), pId:node.id,  name:value, dropInner:false, dropRoot:false});
			s_arr[i].remove();
		}
		updateType();
	}
	$.fn.zTree.init($("#tree_index"), setting, data);
	/*plupload*/
	var i_upload=$("#uploader").plupload({
		// General settings
       	runtimes: 'html5,flash,silverlight,html4',
       	url: "http://localhost:8080/dzdaNew/upload.do",

       	// Maximum file size
       	max_file_size: '2mb',
        
       	chunk_size: '1mb',

       	// Rename files by clicking on their titles
       	rename: true,

       	// Sort files
       	sortable: true,

       	// Enable ability to drag'n'drop files onto the widget (currently only HTML5 supports that)
       	dragdrop: true,

       	// Views to activate
       	views: {
       		list: true,
           		thumbs: true, // Show thumbs
            		active: 'thumbs'
        	},

        	// Flash settings
        	flash_swf_url: 'resources/js/Moxie.swf',

        	// Silverlight settings
        	silverlight_xap_url: 'resources/js/Moxie.xap',
        	// Specify what files to browse for
        	filters: [
            		{title: "Image files",extensions: "jpg,jpeg,tif"}
        	]
    	});
	/*添加按钮*/
	$("#btn_add").on("click",function(){
		var errorMess="";
		$tree=$.fn.zTree.getZTreeObj("tree_index");
		if($tree.getSelectedNodes().length==0)
			errorMess +="您尚未选择目标文件夹";
		if($(".plupload_file:not(.line_added)").has($(".plupload_file_checkInput:checked").not(".check_invisible")).length==0){
			if(errorMess==""){
				errorMess="您尚未选择要导入的图片"
			}else{
				errorMess +="、要导入的图片"
			}
		}
		if (errorMess != "") {
			alert(errorMess);
			return;
		}
		var node=$tree.getSelectedNodes()[0];
		if(node.level !=1){
			alert("请选择二级目录！");
			return ;
		}
		if(node.check_Child_State==-1)
			$tree_size=0;
		else
			$tree_size=node.children.length;
		$(".plupload_file:not(.line_added)").has($(".plupload_file_checkInput:checked").not(".check_invisible")).each(function(){
			var value=$(this).find(".plupload_file_namespan").text();
			$tree_size +=1;
			treeNode = $tree.addNodes(node, {id:(node.id*10 + $tree_size), pId:node.id,  name:value, dropInner:false, dropRoot:false});
			$(this).remove();
		});
		updateType();
	});
	
	/*批量添加按钮*/
	$("#btn_add_amount").on('click',function(){
		$tree=$.fn.zTree.getZTreeObj("tree_index");
		if($tree.getSelectedNodes().length==0){
			alert("您尚未选择目标文件夹");
			return ;
		}
		var node=$tree.getSelectedNodes()[0];
		if(node.level !=1){
			alert("请选择二级目录！");
			return ;
		}
		amountAdd(node,$tree);
	});
});