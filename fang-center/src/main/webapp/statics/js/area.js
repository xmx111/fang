var districts=[{name:'岳麓',index:0},{name:'天心',index:1},{name:'雨花',index:2},{name:'开福',index:3},{name:'芙蓉',index:4},{name:'星沙',index:5},{name:'望城',index:6},{name:'长沙周边',index:7},{name:'宁乡',index:8}];
var areaData=[];
areaData[0]=['d,大学城','f,枫林一路','j,金星大道','l,麓谷','q,汽车西站','r,溁湾镇','s,市政府','t,桐梓坡路','y,银盆岭','y,洋湖湿地公园','b,滨江新城','h,含浦','m,梅溪湖','x,湘雅三医院'];
areaData[1]=['b,白沙路','n,南湖路','s,省政府','s,书院路','x,新开铺','y,友谊路','f,芙蓉南路','h,黄兴路步行街','m,暮云','j,金盆岭','t,涂家冲','p,浦沅'];
areaData[2]=['c,赤岗冲','d,东塘','g,高桥','h,侯家塘','j,井湾子路','s,树木岭','y,窑岭','y,雨花亭','z,左家塘','q,汽车南站','s,韶山南路','w,武广新城','y,雨花区政府','h,红星','g,广济桥'];
areaData[3]=['g,广电中心','s,四方坪','w,伍家岭','k,开福区政府','s,松桂园'];
areaData[4]=['h,火车站','m,马王堆','n,年嘉湖','f,芙蓉区政府','f,芙蓉广场','y,袁家岭','l,浏城桥','l,浏阳河畔','q,汽车东站','w,五一广场','s,识字岭','w,晚报大道','w,万家丽广场'];
areaData[5]=['b,板仓路','k,开元路','q,泉塘','x,星沙大道','z,中南汽车大世界','w,万家丽北路'];
areaData[6]=['w,望城'];
areaData[7]=['q,其他'];
areaData[8]=['n,宁乡'];
var trackLine=[{name:'1号线',index:0},{name:'2号线',index:1}];
var trackStation=[];
trackStation[0]=[',汽车北站',',马厂站',',北辰三角洲站',',开福寺站',',文昌阁站',',培元桥站',',五一广场站',',黄兴广场站',',南门口站',',侯家塘站',',南湖路站',',黄土岭站',',凃家冲站',',铁道学院站',',友谊路站',',省政府站',',桂花坪站',',大托站',',中信广场站',',尚双塘站'];
trackStation[1]=[',望城坡站',',金星路站',',西湖公园站',',溁湾镇站',',橘子洲站',',湘江中路站',',五一广场站',',芙蓉广场站',',迎宾路口站',',袁家岭站',',长沙火车站',',锦泰广场站',',万家丽广场站',',人民东路站',',长沙大道站',',沙湾公园站',',杜花路站',',长沙火车南站',',光达站'];
var Area = function(){
    return {
        render: function(id, cid) {
            if (!!cid) {
                Area.renderDistrict(id, cid);
                Area.renderCbd(cid, '', true);
            } else {
                Area.renderDistrict(id);
            }
        },
        renderDistrict: function(id, cid) {
            $(id).empty();
            // $(id).append('<option value="" data-index="-2"></option>');
            $(id).append('<option value="" data-index="-1">全部</option>');
            for (var i = 0; i < districts.length; i ++){
                $(id).append('<option value="' + districts[i].name + '" data-index="' + districts[i].index + '">' + districts[i].name + '</option>');
            }
            $(id).chosen({
                // placeholder_text: '区县',
                disable_search: true
            });
            $(id).on('change', function(){
                Area.renderCbd(cid, id);
            });
        },
        renderCbd: function(id, did, first) {
            var index = $(did).find("option:selected").attr('data-index');
            var text = '请先选择区县';
            $(id).empty();
            if (!first) $(id).chosen('destroy');
            if (index == undefined || index < 0) $(id).append('<option value="" data-index="-2"></option>');
            $(id).append('<option value="" data-index="-1">全部</option>');
            if (index > -1) {
                text = '商圈';
                var cbdStr;
                for (var i = 0; i < areaData[index].length; i ++){
                    cbdStr = areaData[index][i].split(',');
                    $(id).append('<option value="' + cbdStr[1] + '" data-keys="' + cbdStr[0] + '">' + cbdStr[1] + '</option>');
                }
            }
            $(id).chosen({
                placeholder_text: text
            });
        }
    }
}();