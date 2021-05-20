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
    private MenuItemRepository menuItemRepository;
    private ReviewRepository reviewRepository;

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository,
                             MenuItemRepository menuItemRepository,
                             ReviewRepository reviewRepository) {

        this.restaurantRepository = restaurantRepository;
        this.menuItemRepository = menuItemRepository;
        this.reviewRepository = reviewRepository;
    }

    public List<Restaurant> getRestaurants(String region, long categoryId) {
        //TODO:region으로 필터링

        List<Restaurant> restaurants =
                restaurantRepository.findByAddressContainingAndCategoryId(
                        region, categoryId);

        return restaurants;
    }

    public Restaurant getRestaurant(Long id){
       Restaurant restaurant = restaurantRepository.findById(id)
                            .orElseThrow(() ->new RestaurantNotFondException(id));

        List<MenuItem> menuItems = menuItemRepository.findAllByRestaurantId(id);
        restaurant.setMenuItems(menuItems);

        List<Review> review = reviewRepository.findAllByRestaurantId(id);
        restaurant.setReviews(review);

        return restaurant;
    }

    public Restaurant addRestaurant(Restaurant restaurant) {

        return restaurantRepository.save(restaurant);
    }

    @Transactional
    public Restaurant updateRestaurant(long id, Long categoryId, String name, String address) {
    //TODO: update Restaurant....
        Restaurant restaurant = restaurantRepository.findById(id).orElse(null);

        restaurant.updateInformation(categoryId, name, address);

        return restaurant;
    }
}
