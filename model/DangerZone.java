package com.github.Maol.FireAlertAPI.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "danger_zone")
@Data
public class DangerZone  extends Location{
   enum magnitudlist{
       LOW,MEDIUM,HIGH,EXTREME
   }

   private magnitudlist magnitud;

    public double dangerZoneDistance(){
        switch (magnitud){
            case LOW:
                return 150D;
            case MEDIUM:
                return 500D;
            case HIGH:
                return 2000D;
            case EXTREME:
                return 10000D;
        }
        return 0D;
    }
}
