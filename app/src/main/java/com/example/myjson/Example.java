package com.example.myjson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Example {

        @SerializedName("resultdata")
        @Expose
        private Resultdata resultdata;

        public Resultdata getResultdata() {
            return resultdata;
        }

        public void setResultdata(Resultdata resultdata) {
            this.resultdata = resultdata;
        }


}
