package com.example.workeachweek.Infomation;

import lombok.Data;

@Data
public class LostItem {

    public int lost_id;
    public String lost_name;
    public String lost_position;
    public String lost_description;
    public String claim_position;
    public String lost_date;
    public int is_returned;

}
