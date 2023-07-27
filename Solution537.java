class Solution537 {
    public String complexNumberMultiply(String num1, String num2) {
        int real1 = Integer.parseInt(num1.substring(0, num1.indexOf('+')));
        int real2 = Integer.parseInt(num2.substring(0, num2.indexOf('+')));

        int im1 = Integer.parseInt(num1.substring(num1.indexOf('+') + 1, num1.indexOf('i')));
        int im2 = Integer.parseInt(num2.substring(num2.indexOf('+') + 1, num2.indexOf('i')));

        int realRes = (real1 * real2) - (im1 * im2);
        int imRes = (real1 * im2) + (real2 * im1);

        return realRes + "+" + imRes + "i";
    }
}