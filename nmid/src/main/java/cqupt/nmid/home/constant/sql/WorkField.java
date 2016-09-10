package cqupt.nmid.home.constant.sql;

import static cqupt.nmid.home.constant.sql.UpdateType.NONUPDATABLE;
import static cqupt.nmid.home.constant.sql.UpdateType.UPDATEABLE;

public enum WorkField {
    ID("id",NONUPDATABLE),NAME("name",UPDATEABLE),LOGO("logo",UPDATEABLE),VERSION("version",UPDATEABLE),SIZE("size",UPDATEABLE),TIME("time",UPDATEABLE),SUPPORT("support",UPDATEABLE),PROFILE("profile",UPDATEABLE),UTILITY("utility",UPDATEABLE),FEATURE("feature",UPDATEABLE),INSTRUCTION("instruction",UPDATEABLE),ILLUSTRATION("illustration",UPDATEABLE),LINKS("links",UPDATEABLE),PV("pv",UPDATEABLE);
    private String field;
    private final UpdateType uType;
    private WorkField(String field,UpdateType type) {
        this.field=field;
        this.uType=type;
    }
    
    @Override
    public String toString() {
        return field;
    }
    public static boolean contains(String field){
        for(WorkField f:WorkField.values()){
            if(field.equals(f.toString())) return true;
        }
        return false; 
    }
    public static boolean isUpdateable(String field){
        for(WorkField f:WorkField.values()){
            if(field.equals(f.toString())&&f.uType.equals(UPDATEABLE)) return true;
        }
        return false; 
    }
}
