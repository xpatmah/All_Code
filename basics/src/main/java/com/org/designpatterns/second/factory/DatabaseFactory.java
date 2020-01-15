package com.org.designpatterns.second.factory;

public class DatabaseFactory {

	 String type ; 
	
     public DatabaseFactory(String type) {
    	 this.type=type;
	}	
	
     public IConnection createDatabaseConnection(){
    	 if(type.equals("mongo")){
    		 return new MongoDatabaseConnection();
    	 }else if(type.equals("cassendra")){
    		 return new CassendraDatabaseConnection();
    	 }else if(type.equals("sql")){
    		 return new SQLDataBaseConnection();
    	 }
    	 return  null;
     }
     
     public IConnection createDatabaseConnection(String type){
    	 if(type.equals("mongo")){
    		 return new MongoDatabaseConnection();
    	 }else if(type.equals("cassendra")){
    		 return new CassendraDatabaseConnection();
    	 }else if(type.equals("sql")){
    		 return new SQLDataBaseConnection();
    	 }
    	 return  null;
     }
}
