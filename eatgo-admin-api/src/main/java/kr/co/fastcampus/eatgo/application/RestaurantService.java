package kr.co.fastcampus.eatgo.application;

import kr.co.fastcampus.eatgo.domain.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RestaurantService {

    private RestaurantRepository restaurantRepository;


    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository) {

        this.restaurantRepository = restaurantRepository;

    }

    public List<Restaurant> getRestaurants() {
        List<Restaurant> restaurants = restaurantRepository.findAll();

        return restaurants;
    }

    public Restaurant getRestaurant(Long id){
       Restaurant restaurant = restaurantRepository.findById(id)
                            .orElseThrow(() ->new RestaurantNotFondException(id));

        return restaurant;
    }

    public Restaurant addRestaurant(Restaurant restaurant) {

        return restaurantRepository.save(restaurant);
    }

    @Transactional
    public Restaurant updateRestaurant(Long id, Long categoryId, String name, String address) {
    //TODO: update Restaurant....
        Restaurant restaurant = restaurantRepository.findById(id).orElse(null);

        restaurant.updateInformation(categoryId, name, address);

        return restaurant;
    }
}
