/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.ioncases.model2;

import edu.globant.ioncases.model.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author federico.calarco
 */

public class CaseProduct extends Product implements Serializable{

    private List<Device> compatibleDevices = new ArrayList<>();
    private String design;


}
