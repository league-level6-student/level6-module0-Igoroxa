package _10_white_box_testing;

import _09_intro_to_white_box_testing.models.DeliveryService;
import _09_intro_to_white_box_testing.models.Order;
import _10_white_box_testing.models.BakeryService;
import _10_white_box_testing.models.PaymentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import java.util.Collections;
import java.util.List;

class MyDonutShopTest {

    MyDonutShop myDonutShop;
    
    @Mock
    MyDonutShop shopper;

    @BeforeEach
    void setUp() {
    	MockitoAnnotations.openMocks(this);
    	
    	List<MyDonutShop> avaliableShops = Collections.singletonList(myDonutShop);
   
    	
    }

    @Test
    void itShouldTakeDeliveryOrder() throws Exception {
        //given
    	boolean takenDeliveryOrder = true;
        //when
    	myDonutShop.takeOrder(null); 
        //then
    	
    }

    @Test
    void givenInsufficientDonutsRemaining_whenTakeOrder_thenThrowIllegalArgumentException() {
        //given

        //when

        //then
    }

    @Test
    void givenNotOpenForBusiness_whenTakeOrder_thenThrowIllegalStateException(){
        //given

        //when

        //then
    }

}