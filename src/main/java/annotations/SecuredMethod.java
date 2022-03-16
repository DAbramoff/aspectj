package annotations;

public class SecuredMethod {
    @Secured(isLocked = true)
    public void lockedMethod() {
        System.out.println("lockedMethod");
    }

    @Secured(isLocked = false)
    public void unlockedMethod() {
        System.out.println("unlockedMethod()");
    }

    public static void main(String[] args) throws Exception {
        SecuredMethod sv = new SecuredMethod();
        sv.lockedMethod();
    }
}
