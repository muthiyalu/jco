package org.jco.applications.domain.core;


import java.util.HashMap;

public abstract class AbstractDomainObject {


    private HashMap<String, PropertyGroup> propertyGroupList = new HashMap<>();


    public void addPropertyGroup(PropertyGroup propertyGroup, String pgName){
        propertyGroupList.put(pgName, propertyGroup);

    }

    public PropertyGroup getPropertyGroup(String pgName){
      return  propertyGroupList.get(pgName);
    }
}