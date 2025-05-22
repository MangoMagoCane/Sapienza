public class Test {
    public static void main(String[] args) {
        // List<Titolo> l = list.of(t1, t2, t3, t4, t5);

        Set<Titolo> result1 = l.stream()
                    .filter(t -> t.getRighe().size <= 1)
                    .limit(5)
                    .collect(Collectors.toSet());
        result1.forEach(System.out::println);

        List<Titolo> result2b = l.stream()
                    .filter(Titolo::isCentered)
                    .sorted((a, b) -> a.toString().compareTo(b.toString()))
                    .collect(Collectors.toList());

        List<Titolo> result2b = l.stream()
                    .filter(Titolo::isCentered)
                    .sorted(Comparator.comparing(Titolo::toString))
                    .collect(Collectors.toList());

        Map<Titolo.Allineamento, List<Titolo>> result3a = l.stream()
                    .collect(Collectors.groupingBy(Titolo::getAllineamento));

        Map<Allineamento, Set<Titolo>> result4a = l.stream()
                    .collect(Collectors.groupingBy(
                        Titolo::getAllineamento,
                        Collectors.toSet()));

        Map<Allineamento, String> resulta5a = l.stream()
                    .collect(Collectors.groupingBy(
                        Titolo::getAllineamento,
                        Collectors.mapping(
                            Titolo::toString,
                            Collectors.joining("|"))));

        Map<Allineamento, List<String>> result6a = l.stream()
                    .collect(Collectors.groupingBy(
                        Titolo::getAllineamento,
                        Collectors.mapping(
                            Titolo::toString,
                            Collectors.toList())));

        Set<String> result7a = l.stream()
                    .map(Titolo::getRighe)
                    .flatmap(List::stream)
                    .collect(Collectors.toSet())
                    .map(Riga::toString)
                    .collect(Collectors.toSet());
    }
}
