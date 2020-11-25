public class GAMain {

    /**
     * 将DNA（2进制序列转换为10进制数字）
     * @param DNA 2进制序列
     * @param encodeLength 编码时的长度
     * @return 转换后的数
     */
    long DecodeDNA(String DNA, int encodeLength) {
        long decimal =0;
        char[] DNAx = DNA.toCharArray();
        for (int i = 0,  j = 0; i < encodeLength; i++, j++) {
            decimal += (DNAx[j] - '0')<<(encodeLength - 1 - i);  //将二进制转换为 十进制的值
        }
        return decimal;
    }

    /**
     * 计算整个族群的目标值
     * @param DNAs 整个族群的DNA序列
     * @param encodeLength 编码长度
     * @param Nums 族群的数量
     * @return
     */
    double[] CalculateObjectValue(String[] DNAs, int encodeLength,int Nums) { // DNA 为 编码后的二进制序列，encodeLength为编码长度

        double[] Ys = new double[Nums];//存放目标值
        long temp;  //存放解码后的临时值
        double x;   //X值
        double y;   //Y值

        for (int i = 0; i < Nums; i++) //全部个体
        {
            temp = DecodeDNA(DNAs[i], encodeLength);
            x = (2 - (-1)) * temp / (Math.pow(2, encodeLength) - 1.0) + (-1);
            y= x * Math.sin(10 * Math.PI * x) + 2.0;//函数值
            Ys[i] = y;
        }
        return Ys;
    }

}
