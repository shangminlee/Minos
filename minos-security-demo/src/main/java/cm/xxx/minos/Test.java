package cm.xxx.minos;

import lombok.extern.slf4j.Slf4j;

/**
 * Description:
 * Author: lishangmin
 * Created: 2018-08-03 10:54
 */
@Slf4j
public class Test {

    public static void main(String[] args) {
        log.info("{}",~(10 << 2));
        int v = -5;
        log.info("{}",(Integer.toBinaryString(-v)));
        log.info("{}",(Integer.toBinaryString(+v)));
        log.info("{}",(Integer.toBinaryString(~(+v))));
        log.info("{}",(~(+v)));

        log.info("{}", -5 >> 1);

        log.info("{}",(Integer.toBinaryString( v)));
        log.info("{}",(Integer.toBinaryString( v >> 1)));
        log.info("{}",(v >> 1));
        log.info("{}",(Integer.toBinaryString( v >>> 1)));
        log.info("{}",(v >>> 1));
        log.info("{}",(Integer.toBinaryString( v >>> 1 << 1)));

        log.info("{}",(Integer.toBinaryString( v >>> 1 << 1)).length());
        log.info("{}",(v >>> 1 << 1));

        log.info("{}",(Integer.toBinaryString( -3)));

        log.info("Max:{}",(Integer.toBinaryString(Integer.MAX_VALUE)));
        log.info("Max Length:{}",(Integer.toBinaryString(Integer.MAX_VALUE)).length());
        log.info("Max Value:{}",(Integer.MAX_VALUE));
        log.info("Max Value:{}",~(Integer.MAX_VALUE) + 1);
        log.info("Min:{}",(Integer.toBinaryString(Integer.MIN_VALUE)));
        log.info("Min Lenght:{}",(Integer.toBinaryString(Integer.MIN_VALUE)).length());
        log.info("Min Value:{}",(Integer.MIN_VALUE));

        log.info("{}","------------------------------------------------------------------");
        long l = -5;
        log.info("{}",(Long.toBinaryString(-l)));
        log.info("{}",(Long.toBinaryString(+l)));
        log.info("{}",(Long.toBinaryString(~(+l))));
        log.info("{}",(~(+l)));

        log.info("{}", -5 >> 1);

        log.info("{}",(Long.toBinaryString( l)));
        log.info("{}",(Long.toBinaryString( l >> 1)));
        log.info("{}",(l >> 1));
        log.info("{}",(Long.toBinaryString( l >>> 1)));
        log.info("{}",(l >>> 1));
        log.info("{}",(Long.toBinaryString( l >>> 1 << 1)));

        log.info("{}",(Long.toBinaryString( l >>> 1 << 1)).length());

        log.info("{}","------------------------------------------------------------------");
        float f = -5.11F;

        log.info("{}","------------------------------------------------------------------");
        double d = -5.11D;

        log.info("{}",6%7);

    }
}
