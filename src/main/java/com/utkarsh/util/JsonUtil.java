package com.utkarsh.util;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import java.io.IOException;

public class JsonUtil {
    private static ObjectMapper mapper;
    static {
        mapper= new ObjectMapper();
    }
    public static String convertJavaToJson(Object object)  {
        String jsonResult= "";
        try{jsonResult = mapper.writeValueAsString(object);}
        catch (JsonGenerationException e){
            System.out.println("JsonGenerationException");
        }catch (JsonMappingException e){
            System.out.println("JsonMappingException");
        }catch (IOException e){
            System.out.println("Ioexception");
        }
        return jsonResult;
    }
    public static <T> T convertJsonToJava(String jsonString,Class<T> cls){
        T result = null;
        try {
            result=mapper.readValue(jsonString,cls);
        } catch (IOException e) {
            System.out.println("IOException in convertJsonToJava method");
        }
        return result;

    }
}
