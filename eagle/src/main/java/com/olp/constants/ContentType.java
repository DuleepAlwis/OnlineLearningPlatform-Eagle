package com.olp.constants;

public enum ContentType {

    VIDEO("Video"),AUDIO("Audio"),IMAGE("Image"),PDF("Pdf");

    private String value;
     ContentType(String value){
        this.value = value;
    }

    public String getValue(){
         return this.value;
    }
    @Override
    public String toString() {
        return super.toString();
    }
}
