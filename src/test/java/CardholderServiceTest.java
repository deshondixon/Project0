import com.revature.daos.CardholderDAOInterface;
import com.revature.models.Cardholder;
import com.revature.service.CardholderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CardholderServiceTest {
    @Mock
    private CardholderDAOInterface cardholderDAO;

    @InjectMocks
    private CardholderService cardholderService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testUpdateCardholder() {
        int id = 1;
        String firstName = "John";
        String lastName = "Doe";

        when(cardholderDAO.updateCardholder(firstName, lastName, id)).thenReturn(true);

        boolean isUpdated = cardholderService.updateCardholder(new Cardholder(firstName, lastName), id);

        assertTrue(isUpdated);
        verify(cardholderDAO, times(1)).updateCardholder(firstName, lastName, id);
    }




    @Test
    public void testInsertCardholder() {
        Cardholder cardholder = new Cardholder(1, "John", "Doe");

        when(cardholderDAO.insertCardholder(cardholder)).thenReturn(cardholder);

        Cardholder insertedCardholder = cardholderService.insertCardholder(cardholder);

        assertEquals(cardholder, insertedCardholder);
        verify(cardholderDAO, times(1)).insertCardholder(cardholder);
    }


    @Test
    public void testDeleteCardholder() {

        int id = 1;

        when(cardholderDAO.deleteCardholder(id)).thenReturn(true);

        boolean isDeleted = cardholderService.deleteCardholder(id);

        assertTrue(isDeleted);
        verify(cardholderDAO, times(1)).deleteCardholder(id);
    }
}
