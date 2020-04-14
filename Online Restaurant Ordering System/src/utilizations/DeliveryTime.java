package utilizations;

import java.util.List;

public class DeliveryTime {

    public Time calculateTimeDeliveryTime(List<Time> ordersPreparingTimes){
        Time deliveryTime = new Time();
        deliveryTime.setHour(0);
        deliveryTime.setMinuet(0);

        for (Time temp : ordersPreparingTimes){
            deliveryTime = deliveryTime.add(temp);
        }

        return deliveryTime;
    }


}
