import com.revature.daos.PaymentDAOInterface;
import com.revature.models.Payment;
import com.revature.service.PaymentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

public class PaymentServiceTest {

    @Mock
    private PaymentDAOInterface paymentDAO;

    @InjectMocks
    private PaymentService paymentService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetPaymentById() {
        Payment expectedPayment = new Payment();
        expectedPayment.setPayment_ID(2);
        expectedPayment.setBill("Not Paid");
        expectedPayment.setDueDate("06/15");
        expectedPayment.setCardholder_id_fk(2);

        when(paymentDAO.getPaymentById(2)).thenReturn(expectedPayment);

        Payment actualPayment = paymentService.getPaymentById(2);
        assertEquals(expectedPayment.getPayment_ID(), actualPayment.getPayment_ID());
        assertEquals(expectedPayment.getBill(), actualPayment.getBill());
        assertEquals(expectedPayment.getDueDate(), actualPayment.getDueDate());
        assertEquals(expectedPayment.getCardholder_id_fk(), actualPayment.getCardholder_id_fk());
    }

    @Test
    void testDeletePayment() {
        int paymentId = 3;

        when(paymentDAO.deletePayment(paymentId)).thenReturn(true);

        boolean deleted = paymentService.deletePayment(paymentId);
        assertTrue(deleted);
    }
}
