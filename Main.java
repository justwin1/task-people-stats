public static void main(String[] args) {
    PeopleStats peopleStats = new PeopleStats(Paths.get("��ie�ka", "do", "pliku"));

    System.out.println(String.format("Liczba os�b: %d", peopleStats.count()));
    System.out.println(String.format("Liczba os�b z unikalnymi nazwiskami: %d", peopleStats.countUniqueLastNames()));
}

class PeopleStats {
    private final List<Person> people;

    public PeopleStats(Path inputFilePath) {
        try {
            people = Files.lines(inputFilePath)
                    .map(line -> line.split("\t"))
                    .map(chunks -> new Person(chunks[0], chunks[1]))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
    public long count() {
    return people.size();
}
    public long countUniqueLastNames() {
    return people.stream()
            .map(Person::getLastName)
            .distinct()
            .count();
}

}

class Person {
    private final String firstName;

    private String lastName;



    public Person(String firstName, String lastName) {
        this.firstName = firstName;
	this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
	return lastName;
    }

}