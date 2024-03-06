package id.ac.ui.cs.advprog.eshop.model;

import id.ac.ui.cs.advprog.eshop.enums.PaymentStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class PaymentTest {
    Map<String, String> paymentData;

    @BeforeEach
    void setUp() {
        this.paymentData = new HashMap<>();
        paymentData.put("voucherCode", "ESHOP1234ABC5678");
    }

    @Test
    void testCreatePaymentEmptyPaymentData() {
        this.paymentData.clear();
        assertThrows(IllegalArgumentException.class, () -> {
            new Payment("e6e60d39-41fb-4ff0-8631-3491e483c180",
                    "VOUCHER", paymentData);
        });
    }

    @Test
    void testCreatePaymentDefaultStatus() {
        Payment payment = new Payment("e6e60d39-41fb-4ff0-8631-3491e483c180",
                "VOUCHER", paymentData);

        assertEquals("e6e60d39-41fb-4ff0-8631-3491e483c180", payment.getId());
        assertEquals("VOUCHER", payment.getMethod());
        assertEquals(PaymentStatus.REJECTED.getValue(), payment.getStatus());
        assertEquals(this.paymentData, payment.getPaymentData());
    }

    @Test
    void testCreatePaymentSuccessStatus() {
        Payment payment = new Payment("e6e60d39-41fb-4ff0-8631-3491e483c180",
                "VOUCHER", PaymentStatus.SUCCESS.getValue(), paymentData);
        assertEquals(PaymentStatus.SUCCESS.getValue(), payment.getStatus());

    }

    @Test
    void testCreateOrderInvalidStatus() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Payment("e6e60d39-41fb-4ff0-8631-3491e483c180",
                    "VOUCHER", "MEOW", paymentData);
        });
    }

    @Test
    void testSetStatusToSuccess() {
        Payment payment = new Payment("e6e60d39-41fb-4ff0-8631-3491e483c180",
                "VOUCHER", paymentData);
        payment.setStatus(PaymentStatus.SUCCESS.getValue());
        assertEquals(PaymentStatus.SUCCESS.getValue(), payment.getStatus());
    }

    @Test
    void testSetStatusToInvalidStatus() {
        Payment payment = new Payment("e6e60d39-41fb-4ff0-8631-3491e483c180",
                "VOUCHER", paymentData);
        assertThrows(IllegalArgumentException.class, () -> payment.setStatus("MEOW"));
    }
}