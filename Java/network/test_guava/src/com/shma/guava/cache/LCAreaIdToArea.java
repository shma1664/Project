package com.shma.guava.cache;

import java.util.concurrent.ExecutionException;

public class LCAreaIdToArea extends GuavaAbstractLoadingCache<Integer, Area>
		implements ILocalCache<Integer, Area> {

	@Override
	public Area get(Integer key) {
		try {
			return super.getValue(key);
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	protected Area fetchData(Integer key) {
		//return areasDAO.getAreaById(key);  
        //测试专用，实际项目使用areaDao从数据库中获取数据 
		Area a = new Area();  
        a.setCode(key);  
        a.setId(key);  
        a.setName("地区："+key);  
        a.setParentCode(Integer.valueOf(key.toString().substring(0, key.toString().length()-3)));  
        a.setPinyin("pinyin:"+key);  
        a.setType(1);  
          
        return a;
	}

	
}
