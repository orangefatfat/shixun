// 课堂练习③：字符串处理与日期计算综合练习（5 道小题）
// 对应业务：编码倒序校验 / 日志关键字计数 / 订单流水号 / 活动倒计时 / 报表日期展示
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Random;

public class Exercise3 {
    public static void main(String[] args) {
        // 题1：反转字符串（StringBuilder.reverse）——编码倒序校验
        String code = "abc123";
        String reversed = new StringBuilder(code).reverse().toString();
        System.out.println("题1 反转: " + reversed);   // 321cba

        // 题2：统计字符串中某字符出现次数——日志关键字计数
        String log = "error:404 error:500 error:404 error:500";
        char target = 'e';
        int count = 0;
        for (int i = 0; i < log.length(); i++) {
            if (log.charAt(i) == target) count++;
        }
        System.out.println("题2 字符 '" + target + "' 出现次数: " + count);

        // 题3：生成订单号：yyyyMMddHHmmss + "-" + 4 位随机数——订单流水号
        String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        int code4 = new Random().nextInt(9000) + 1000;   // 4 位随机数（1000~9999）
        String orderNo = time + "-" + code4;
        System.out.println("题3 订单号: " + orderNo);

        // 题4：今天距离 2026-09-30 还有多少天（ChronoUnit.DAYS）——活动倒计时
        LocalDate deadline = LocalDate.of(2026, 9, 30);
        long days = ChronoUnit.DAYS.between(LocalDate.now(), deadline);
        System.out.println("题4 距离 2026-09-30 还有 " + days + " 天");

        // 题5：解析后格式化输出——必须走 parse + format，不许字符串截取硬拼
        DateTimeFormatter inFmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dt = LocalDateTime.parse("2026-08-27 14:30:00", inFmt); // parse
        DateTimeFormatter outFmt = DateTimeFormatter.ofPattern("yyyy年M月d日");
        System.out.println("题5 格式化输出: " + dt.format(outFmt));            // format → 2026年8月27日
    }
}
