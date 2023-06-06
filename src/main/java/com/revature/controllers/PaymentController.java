import com.revature.service.PaymentService;
import com.revature.models.Payment;
import io.javalin.http.Context;

import java.util.ArrayList;

public class PaymentController {
    private PaymentService paymentService = new PaymentService();

    public void getAllPayments(Context ctx) {
        ArrayList<Payment> paymentList = paymentService.getAllPayments();
        ctx.json(paymentList);
    }

    public void insertPayment(Context ctx) {
        Payment payment = ctx.bodyAsClass(Payment.class);
        Payment insertedPayment = paymentService.insertPayment(payment);
        if (insertedPayment != null) {
            ctx.status(201);
            ctx.json(insertedPayment);
        } else {
            ctx.status(400);
        }
    }

    public void updatePayment(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        Payment payment = ctx.bodyAsClass(Payment.class);
        boolean updated = paymentService.updatePayment(payment.getBill(), payment.getDueDate(), id);
        if (updated) {
            ctx.status(200);
        } else {
            ctx.status(400);
        }
    }

    public void deletePayment(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        boolean deleted = paymentService.deletePayment(id);
        if (deleted) {
            ctx.status(204);
        } else {
            ctx.status(400);
        }
    }
}
