package Stream.Tasks.SkillFactory.AdditionalTask2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo {

    /**
     * В текущем рабочем каталоге-файле есть список трат в строках, в формате «имя, сумма».
     *
     * Шаблон balance.txt:
     *
     * Дима, 510
     * Катя, 2800
     * Никита, 1500
     * Эмилия, 5000
     * Ярослав, 3000
     * Андрей
     * Что нужно сделать?
     *
     * 0. Скопировать текст из задания в файл balance.txt в текущий рабочий каталог.
     *
     * 1. Прочесть файл balance.txt в Map<String, Integer>.
     *
     * 2. Отсортировать строки файла в убывающем порядке.
     *
     * 3. Добавить в конце списка сумму всех трат: "Итого: n руб. (дата формирования файла в формате dd.MM.yyyy)", пример: "Итого: 100 руб. (01.03.2021)".
     *
     * 4. Сохранить файл как balance_total_ddMMyy.txt, где ddMMyy — это день, число и год слитно.
     */

    public static void main(String[] args) {

        // current date
        final LocalDate now = LocalDate.now(); // 2021-05-31

        // formatted current date
        final String formattedDate = now.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")); // 31.05.2021

        // formatted current date for file name
        final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("ddMMyy"); // 310521
        final String dateForFilename = SIMPLE_DATE_FORMAT.format(now.atStartOfDay().toInstant(ZoneOffset.UTC).toEpochMilli()); // idk


        // path to file
        final Path fileSource = Paths.get(
                "src", "Stream", "Tasks", "SkillFactory", "AdditionalTask2", "balance.txt");

        // path to file where result will be stored
        final Path fileToWrite = Paths.get(
                "src", "Stream", "Tasks", "SkillFactory", "AdditionalTask2", "balance_total_" + dateForFilename + ".txt");

        try {
            // [Дима, 510, Катя, 2800, Никита, 1500, Эмилия, 5000, Ярослав, 3000, Андрей], where
            // 0 index -> "Дима, 510" ; 1 index -> "Катя, 2800" ; 2 index -> "Никита, 1500" ; etc.
            final List<String> strings = Files.readAllLines(fileSource, Charset.defaultCharset());

            final List<String[]> sortedNames = strings.stream()
                    .map(s -> { // ["Дима, 510"]
                        final String[] split = s.split(","); // ["Дима", " 510"]
                        return new String[]{
                                split[0], // "Дима"
                                split.length > 1? split[1].trim(): "0" // split[1].trim() -> "510"
                        };
                    })
                    .sorted((o1, o2) -> Integer.parseInt(o2[1]) - Integer.parseInt(o1[1])) // from more to less
                    .collect(Collectors.toList()); // [[Эмилия, 5000], [Ярослав, 3000], [Катя, 2800], [Никита, 1500], [Дима, 510], [Андрей, 0]]

            try (BufferedWriter writer = Files.newBufferedWriter(fileToWrite, Charset.defaultCharset())) {
                for (String[] split: sortedNames) { // split -> [Эмилия, 5000]
                    writer.write(String.format("%s\n", String.join(", ", split))); // "Эмилия, 5000\n"
                }

                writer.append(String.format(
                        "===\nИтого: %d руб.(%s)",
                        sortedNames.stream().mapToInt(split -> Integer.parseInt(split[1])).sum(), // 12810
                        formattedDate // 31.05.2021
                ));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
