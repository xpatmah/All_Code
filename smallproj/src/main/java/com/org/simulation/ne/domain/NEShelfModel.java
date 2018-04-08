package com.org.simulation.ne.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.org.simulation.ne.NeConstants;

public class NEShelfModel {

	private Map<String,List<Card>> sSeriesSlotCardMap = new HashMap<String, List<Card>>();

	private Map<String,List<Card>> tSeriesSlotCardMap = new HashMap<String, List<Card>>();

	
	
	public Map<String,List<Card>> getSelfModel(String neSelfModel){
		if(NeConstants.T_SERIES.equals(neSelfModel)){
			return gettSeriesSlotCardMap();
		}else if(NeConstants.S_SERIES.equals(neSelfModel)){
			return getsSeriesSlotCardMap() ;
		}else{
			return null;
		}
	}
	
	private Map<String,List<Card>> gettSeriesSlotCardMap() {
		return tSeriesSlotCardMap;
	}

	private Map<String,List<Card>> getsSeriesSlotCardMap() {
		return sSeriesSlotCardMap;
	}





}


