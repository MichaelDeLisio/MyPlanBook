package utm.csc301.theBrogrammers.myPlanBook.LogCalories;

import java.util.ArrayList;
import java.util.HashMap;

public class CaloriesModel {

    private HashMap<String, ArrayList<String>> foodByDate;

    public CaloriesModel() {
        foodByDate = new HashMap<String, ArrayList<String>>();
    }

    public void addFoodCalories(String date, String foodAndCalories) {
        if (this.foodByDate.containsKey(date) && this.foodByDate.get(date).size() <= 100) {
            this.foodByDate.get(date).add(foodAndCalories);
        }
        else {
            ArrayList<String> foodCaloriesForDate = new ArrayList<String>();
            foodCaloriesForDate.add(foodAndCalories);
            this.foodByDate.put(date, foodCaloriesForDate);
        }
    }

    public ArrayList<String> getFoodCalories(String date) {
        if (this.foodByDate.containsKey(date)){
            return this.foodByDate.get(date);
        }
        else {
            return  null;
        }
    }

}
