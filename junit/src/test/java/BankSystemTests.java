import org.blitmatthew.BankSystem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankSystemTests {

    @Test
    public void BankSystem_WithdrawFromChecking_ShouldSucceed() {
        BankSystem bankSystem = new BankSystem();
        bankSystem.withdraw(500, "Checking", "Saving");
        assertEquals(4500, bankSystem.getCheckingAccount());
        assertEquals(5500, bankSystem.getSavingAccount());
    }
}
