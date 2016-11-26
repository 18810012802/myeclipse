/**
 * @fileOverview ����ҳ��ҵ��ؼ�
 * @ignore
 */

define('common/search',['bui/common','bui/grid','bui/form','bui/data','bui/overlay'],function (require) {
  var BUI = require('bui/common'),
    Grid = require('bui/grid'),
    Data = require('bui/data'),
    Overlay = require('bui/overlay'),
    Form = require('bui/form');

  /**
   * @class Search
   * ����ҳ��
   */
  function Search(config){

    Search.superclass.constructor.call(this, config);
    this._init();
  }

  Search.ATTRS = {
    /**
     * �Ƿ��Զ���ѯ����ҳ��ʱδ�����ѯ��ťʱ�Ƿ��Զ���ѯ
     * @type {Boolean}
     */
    autoSearch :{
      value : true
    },
    /**
     * grid ������ id
     * @type {String}
     */
    gridId : {
      value : 'grid'
    },
    /**
     * ����������id
     * @type {String}
     */
    formId : {
      value : 'searchForm'
    },
    /**
     * ��ѯ��ť��id
     * @type {Object}
     */
    btnId : {
      value : 'btnSearch'
    },
    /**
     * ����������
     * @type {Object}
     */
    formCfg : {
      value : {}
    },
    /**
     * grid ����������
     * @type {Object}
     */
    gridCfg : {

    },
    /**
     * ������
     * @type {Object}
     */
    form : {

    },
    /**
     * ������
     * @type {Object}
     */
    grid : {

    },
    /**
     * ���ݻ�����
     * @type {Object}
     */
    store : {

    }
  }

  BUI.extend(Search,BUI.Base);

  BUI.augment(Search,{
    _init : function(){
      var _self = this;

      _self._initForm();
      _self._initStoreEvent();
      _self._initGrid();
      _self._initEvent();
      _self._initData();
    },
    //��ʼ���¼�
    _initEvent : function(){
      this._initDomEvent();
      this._initFormEvent();
      this._initGridEvent();
    },
    _initDomEvent : function(){
      var _self = this,
        btnId = _self.get('btnId'),
        store = _self.get('store'),
        form = _self.get('form');
      $('#'+btnId).on('click',function(ev){
        ev.preventDefault();
        form.valid();
        if(form.isValid()){
          _self.load(true);
        }
      });
    },
    //��ʼ��form
    _initForm : function(){
      var _self = this,
        form = _self.get('form');
      if(!form){
        var formCfg = BUI.merge(_self.get('formCfg'),{
          srcNode : '#' + _self.get('formId')
        });
        form = new Form.HForm(formCfg);
        form.render();
        _self.set('form',form);
      }
    },
    _initFormEvent : function(){

    },
    //��ʼ�����
    _initGrid : function(){
      var _self = this,
        grid = _self.get('grid');
      if(!grid){
        var gridCfg = _self.get('gridCfg'),
          store = _self.get('store');
        gridCfg.store = store;
        gridCfg.render = '#' +_self.get('gridId'),
        grid = new Grid.Grid(gridCfg);
        grid.render();
        _self.set('grid',grid);
      }
    },
    _initGridEvent : function(){

    },
    _initData : function(){
      var _self = this,
        autoSearch = _self.get('autoSearch');
      if(autoSearch){
        _self.load(true);
      }
    },
    //��ʼ�����ݼ����¼�
    _initStoreEvent : function(){
      var _self = this,
        store = _self.get('store');
      //�����쳣
      store.on('exception',function(ev){
        BUI.Message.Alert(ev.error);
      });
    },
    /**
     * ��������
     * @param {Boolean} reset �Ƿ����ñ���ѯ��ҳ��
     */
    load : function(reset){
      var _self =this,
        form = _self.get('form'),
        store = _self.get('store'),
        param = form.serializeToObject();
      if(reset){
        param.start=0;
        param.pageIndex = 0;
      }
      store.load(param);
    }
  });

  Search.createStore = function(url,cfg){

    cfg = BUI.merge({
      autoLoad : false,
      url : url,
      pageSize : 30
    },cfg);
    return new Data.Store(cfg);
  };

  Search.createGridCfg = function(columns,cfg){
    cfg = BUI.merge({
      columns : columns,
      loadMask : true,
      bbar:{
        pagingBar:true
      }
    },cfg);
    
    return cfg;
  };

  Search.createLink = function(cfg){
    var temp = '<span class="page-action grid-command" data-id="{id}" data-href="{href}" title="{title}">{text}</span>';
    return BUI.substitute(temp,cfg);
  }
  return Search;
});