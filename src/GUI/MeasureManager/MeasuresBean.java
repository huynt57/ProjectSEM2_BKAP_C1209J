/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI.MeasureManager;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class MeasuresBean {
  private int measureCode;
    private String measureName;

    public int getMeasureCode() {
        return measureCode;
    }

    public void setMeasureCode(int measureCode) {
        this.measureCode = measureCode;
    }

    public String getMeasureName() {
        return measureName;
    }

    public void setMeasureName(String measureName) {
        this.measureName = measureName;
    }

    public MeasuresBean(int measureCode, String measureName) {
        this.measureCode = measureCode;
        this.measureName = measureName;
    }
    
    public MeasuresBean() {
    }
}
