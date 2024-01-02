package Projects.Marselle.controllers;

import Projects.Marselle.dto.PersonDto;
import Projects.Marselle.models.Person;
import Projects.Marselle.models.furniture.Delivery;
import Projects.Marselle.models.furniture.Product;
import Projects.Marselle.models.furniture.WorkInfo;
import Projects.Marselle.models.work.DeliveryENUM;
import Projects.Marselle.models.work.EdgingENUM;
import Projects.Marselle.models.work.SawENUM;
import Projects.Marselle.security.PersonDetails;
import Projects.Marselle.services.*;
import Projects.Marselle.util.SalaryCalculating;
import Projects.Marselle.util.TextParser;
import Projects.Marselle.util.exceptions.IncorrectNumberOfWordsException;
import org.dom4j.rule.Mode;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@RestController
public class SalaryController {

    private final ModelMapper modelMapper;
    private final PeopleService peopleService;
    private final SawService sawService;

    private final WorkInfoService workInfoService;
    private final EdgingService edgingService;
    private final DeliveryService deliveryService;
    private final ProductService productService;

    @Autowired
    public SalaryController(ModelMapper modelMapper, PeopleService peopleService, SawService sawService, WorkInfoService workInfoService, EdgingService edgingService, DeliveryService deliveryService, ProductService productService) {
        this.modelMapper = modelMapper;
        this.peopleService = peopleService;
        this.sawService = sawService;
        this.workInfoService = workInfoService;
        this.edgingService = edgingService;
        this.deliveryService = deliveryService;
        this.productService = productService;
    }

    @GetMapping("/results-of-the-day")
    public ModelAndView dayResults() {
        ModelAndView modelAndView = new ModelAndView("main/day_results");

        Set<Person> people = new HashSet<>();
        // ищем, какая работа была сделана сегодня
        List<WorkInfo> todayReport = workInfoService.findAllByDate(new Date());
        List<String> peopleString = new ArrayList<>();

        // получаем множество тех, кто сегодня отметился по работе
        for (WorkInfo work : todayReport) {
            people.add(work.getPersonWork());
//            System.out.println(work.getNameOfWork());
        }

        for (Person p : people) {
            peopleString.add(p.getUsername());
            System.out.println(p.getFirst_name());
        }

        modelAndView.addObject("peopleAcceptedWork", peopleString);
        modelAndView.addObject("workers", getWorkersDto());
        modelAndView.addObject("personDto", getCurrentUserDto());

        return modelAndView;
    }

    @GetMapping("/results-of-the-day/worker")
    public ModelAndView workerResult(@RequestParam(name = "user", required = true) String username) {

        System.out.println(username);
        ModelAndView modelAndView = new ModelAndView("salary/calculating_salaries");

        PersonDto foundPersonDto = getPersonDtoByUsername(username);
        if (getPersonDtoByUsername(username) == null) { // Если не нашли в БД
            ModelAndView redirectModelAndView = new ModelAndView("main/day_results");

            List<Person> workers = peopleService.findAll();
            redirectModelAndView.addObject("workers", workers);

            return redirectModelAndView;
        }

        // Человек, которому считаем сделку
        modelAndView.addObject("personDto", foundPersonDto);

        return modelAndView;
    }

    @PostMapping("/update-worker-salary")
    public ModelAndView updateWorkerSalary(@RequestParam(name = "user", required = true) String username,
                                           @RequestParam(name="result", required = false) String result,
                                           @RequestParam(name = "saw16", required = false) String saw16,
                                           @RequestParam(name = "saw4", required = false) String saw4,
                                           @RequestParam(name = "saw26", required = false) String saw26,
                                           @RequestParam(name = "edging", required = false) String edging,
                                           @RequestParam(name = "newCityDelivery", required = false) String newCityDelivery,
                                           @RequestParam(name = "oldCityDelivery", required = false) String oldCityDelivery,
                                           @RequestParam(name = "komsaDelivery", required = false) String komsaDelivery,
                                           @RequestParam(name = "samaraDelivery", required = false) String samaraDelivery,
                                           @RequestParam(name = "otherDelivery", required = false) String otherDelivery) {
        boolean standartPositionsError = false;
        boolean saw16Error = false;
        boolean saw4Error = false;
        boolean saw26Error = false;
        boolean edgingError = false;

        boolean newCityDeliveryError = false;
        boolean oldCityDeliveryError = false;
        boolean komsaDeliveryError = false;
        boolean samaraDeliveryError = false;
        boolean otherDeliveryError = false;

        ModelAndView modelAndView = new ModelAndView("/salary/confirm_day_job");
        modelAndView.addObject("personDto", getPersonDtoByUsername(username));

        System.out.println(username);
        System.out.println(result);

        // для стандартных позиций
        if (result != null && result != "") {
            if (parseStandartPositions(result) == null) {
                standartPositionsError = true;
            }
            else {
                List<Product> standartPositionsList = parseStandartPositions(result);
                List<String> standartPositionsStringList = new ArrayList<>();
                for (Product position : standartPositionsList) {

                    standartPositionsStringList.add(position.getName());
                }
                modelAndView.addObject("result", result);
                modelAndView.addObject("standartPositions", standartPositionsList);
            }
        }

        if (saw16 != null && !saw16.equals("")) {
            if (TextParser.hasOnlyNumbers(saw16)) {
                // Тут все правильно
//                System.out.println("LDSP 16 - " + Integer.parseInt(saw16));
                Integer saw16num = Integer.parseInt(saw16);
                modelAndView.addObject("saw16", saw16num);
            }
            else {
                System.out.println("LDSP16 error");
                saw16Error = true;
            }
        }

        if (saw26 != null && saw26 != "") {
            if (TextParser.hasOnlyNumbers(saw26)) {
                // Тут все правильно
//                System.out.println("LDSP 26 - " + Integer.parseInt(saw26));
                Integer saw26num = Integer.parseInt(saw26);
                modelAndView.addObject("saw26", saw26num);
            }
            else {
                System.out.println("LDSP26 error");
                saw26Error = true;
            }
        }

        if (saw4 != null && saw4 != "") {
            if (TextParser.hasOnlyNumbers(saw4)) {
//                System.out.println("HDF - " + Integer.parseInt(saw4));
                Integer saw4num = Integer.parseInt(saw4);
                modelAndView.addObject("saw4", saw4num);
            }
            else {
                System.out.println("HDF error");
                saw4Error = true;
            }
        }

        if (edging != null && edging != "") {
            if (TextParser.hasOnlyNumbers(edging)) {
                Integer edgingNum = Integer.parseInt(edging);
//                System.out.println("Edging - " + Integer.parseInt(edging));
                modelAndView.addObject("edging", edgingNum);
            }
            else {
                System.out.println("Edging error");
                edgingError = true;
            }
        }


        if (newCityDelivery != null && newCityDelivery != "") {
            if (TextParser.hasOnlyNumbers(newCityDelivery)) {
                Integer newCityDeliveryNum = Integer.parseInt(newCityDelivery);
                modelAndView.addObject("newCityDelivery", newCityDeliveryNum);
//                System.out.println("new City Delivery - " + Integer.parseInt(newCityDelivery));
            }
            else {
                System.out.println("new City Delivery error");
                newCityDeliveryError = true;
            }
        }

        if (oldCityDelivery != null && oldCityDelivery != "") {
            if (TextParser.hasOnlyNumbers(oldCityDelivery)) {
                Integer oldCityDeliveryNum = Integer.parseInt(oldCityDelivery);
                modelAndView.addObject("oldCityDelivery", oldCityDeliveryNum);
//                System.out.println("old City Delivery - " + Integer.parseInt(oldCityDelivery));
            }
            else {
                System.out.println("old City Delivery error");
                oldCityDeliveryError = true;
            }
        }

        if (komsaDelivery != null && komsaDelivery != "") {
            if (TextParser.hasOnlyNumbers(komsaDelivery)) {
                Integer komsaDeliveryNum = Integer.parseInt(komsaDelivery);
                modelAndView.addObject("komsaDelivery", komsaDeliveryNum);
//                System.out.println("Komsa Delivery - " + Integer.parseInt(komsaDelivery));
            }
            else {
                System.out.println("Komsa Delivery error");
                komsaDeliveryError = true;
            }
        }

        if (samaraDelivery != null && samaraDelivery != "") {
            if (TextParser.hasOnlyNumbers(samaraDelivery)) {
                Integer samaraDeliveryNum = Integer.parseInt(samaraDelivery);
                modelAndView.addObject("samaraDelivery", samaraDeliveryNum);
//                System.out.println("Samara Delivery - " + Integer.parseInt(samaraDelivery));
            }
            else {
                System.out.println("Samara Delivery error");
                samaraDeliveryError = true;
            }
        }

        //TODO много кода, нужно распарсить
        if (otherDelivery != null && otherDelivery != "") {
//            // Если район 1
//            List<Delivery> otherDeliveryList = new ArrayList<>();
//
//            if (otherDelivery.split(",").length == 1) {
//                String[] line = otherDelivery.split(" ");
//
//                StringBuilder stringBuilder = new StringBuilder();
//
//                for (int i = 0; i < (line.length - 1); i++) {
//                    stringBuilder.append(line[i]);
//                    stringBuilder.append(" ");
//                }
//
//                String resultPoint = stringBuilder.toString().trim();
//
//                String countOfPoint = line[line.length - 1].trim();
//
//                if (!TextParser.hasOnlyNumbers(countOfPoint)) {
//
//                    System.out.println("Other delivery error");
//                    otherDeliveryError = true;
//                }
//                else {
//                    Delivery delivery = new Delivery();
//
//                    delivery.setCount(Integer.parseInt(countOfPoint));
//                    delivery.setDate(new Date());
//                    delivery.setDistrict(resultPoint);
//                    otherDeliveryList.add(delivery);
//
//                    modelAndView.addObject("otherDeliveryList", otherDeliveryList);
////                    System.out.println("Other district - " + resultPoint + ", count - " + countOfPoint);
//                }
//            }
//
//            //Если районов несколько
//            if (otherDelivery.split(",").length > 1) {
//                String[] deliveryList = otherDelivery.split(",");
//                for (String address : deliveryList) {
//                    String[] line = address.split(" ");
//
//                    StringBuilder stringBuilder = new StringBuilder();
//
//                    for (int i = 0; i < (line.length - 1); i++) {
//                        stringBuilder.append(line[i]);
//                        stringBuilder.append(" ");
//                    }
//
//                    String resultPoint = stringBuilder.toString().trim();
//
//                    String countOfPoint = line[line.length - 1].trim();
//
//                    if (!TextParser.hasOnlyNumbers(countOfPoint)) {
//                        System.out.println("Other delivery error");
//                        otherDeliveryError = true;
//                    }
//                    else {
//                        Delivery delivery1 = new Delivery();
//
//                        delivery1.setCount(Integer.parseInt(countOfPoint));
//                        delivery1.setDate(new Date());
//                        delivery1.setDistrict(resultPoint);
//                        otherDeliveryList.add(delivery1);
////                        System.out.println("Other district - " + resultPoint + ", count - " + countOfPoint);
//                    }
//
//
//                }
//            }
            List<Delivery> otherDeliveries = TextParser.parseDeliveries(otherDelivery);

            if (otherDeliveries == null) {
                otherDeliveryError = true;
            }
            else {

            }
            modelAndView.addObject("otherDelivery", otherDeliveries);
            modelAndView.addObject("otherDeliveryString", otherDelivery);
        }

        // Если есть ошибки, редиректим обратно
        if (standartPositionsError == true || saw16Error == true || saw4Error == true || saw26Error == true || edgingError == true
        || newCityDeliveryError == true || oldCityDeliveryError == true || komsaDeliveryError == true
        || samaraDeliveryError == true || otherDeliveryError == true) {
            ModelAndView modelAndViewError = workerResult(username);

            modelAndViewError.addObject("standartPositionsError", standartPositionsError);
            modelAndViewError.addObject("saw4Error", saw4Error);
            modelAndViewError.addObject("saw16Error", saw16Error);
            modelAndViewError.addObject("saw26Error", saw26Error);
            modelAndViewError.addObject("edgingError", edgingError);

            modelAndViewError.addObject("newCityDeliveryError", newCityDeliveryError);
            modelAndViewError.addObject("oldCityDeliveryError", oldCityDeliveryError);
            modelAndViewError.addObject("komsaDeliveryError", komsaDeliveryError);
            modelAndViewError.addObject("samaraDeliveryError", samaraDeliveryError);
            modelAndViewError.addObject("otherDeliveryError", otherDeliveryError);


            return modelAndViewError;
        }

        // Если все ок
//        ModelAndView modelAndView1 = new ModelAndView("main/day_results");
//
//        modelAndView1.addObject("workers", getWorkersDto());
//        modelAndView1.addObject("personDto", getCurrentUserDto());

        return modelAndView;
    }

    @PostMapping("/accept_worker_job")
    public ModelAndView confirmDayJob(@RequestParam(name = "user", required = true) String username,
                                      @RequestParam(name="standartPositions", required = false) List<Product> standartPositions,
                                      @RequestParam(name = "result", required = false) String result,
                                      @RequestParam(name = "saw16", required = false) Integer saw16,
                                      @RequestParam(name = "saw4", required = false) Integer saw4,
                                      @RequestParam(name = "saw26", required = false) Integer saw26,
                                      @RequestParam(name = "edging", required = false) Integer edging,
                                      @RequestParam(name = "newCityDelivery", required = false) Integer newCityDelivery,
                                      @RequestParam(name = "oldCityDelivery", required = false) Integer oldCityDelivery,
                                      @RequestParam(name = "komsaDelivery", required = false) Integer komsaDelivery,
                                      @RequestParam(name = "samaraDelivery", required = false) Integer samaraDelivery,
                                      @RequestParam(name = "otherDelivery", required = false) List<Delivery> otherDelivery,
                                      @RequestParam(name = "otherDeliveryString", required = false) String otherDeliveryString) {

        ModelAndView modelAndView = new ModelAndView("/salary/accept_worker_job");
        modelAndView.addObject("user", username);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) auth.getPrincipal();

        System.out.println(result);

        Person currentPerson = personDetails.getPerson();
        Person updatedPerson = peopleService.findByUsername(username).get();

        if (result != null && result != "") {
            HashMap<String, Integer> map = new HashMap<>();


            for (Product product : parseStandartPositions(result)) {
                if (!map.containsKey(product.getName())) {
                    map.put(product.getName(), 1);
                }
                else {
                    map.put(product.getName(), map.get(product.getName()) + 1);
                }
            }

            for (String s : map.keySet()) {
                WorkInfo currentWork = new WorkInfo(updatedPerson.getUsername(), new Date(),
                        s, map.get(s), productService.findByName(s).get().getCostOfWork(), updatedPerson);
                currentWork.setWorker(updatedPerson.getUsername());
                currentWork.setDate(new Date());
                currentWork.setNameOfWork(s);
                currentWork.setCount(map.get(s));
                currentWork.setPersonWork(updatedPerson);

                // умножаем количество изделий на сумму к оплате одного из них
                int costOfWork = currentWork.getCount() * productService.findByName(s).get().getCostOfWork();
                currentWork.setCostOfWork(costOfWork);

                updatedPerson.getWorkInfoList().add(currentWork);
                workInfoService.save(currentWork);
            }

            peopleService.save(updatedPerson);
        }

//        peopleService.save(updatedPerson);


        if (saw16 != null && saw16 >= 0) {
            WorkInfo workInfo = new WorkInfo();

            workInfo.setPersonWork(updatedPerson);
            workInfo.setCount(saw16);
            workInfo.setNameOfWork(SawENUM.CHIPBOARD16.getType());
            workInfo.setDate(new Date());
            workInfo.setCostOfWork(saw16 * SawENUM.CHIPBOARD16.getCostToWork());
            workInfo.setWorker(updatedPerson.getUsername());

            workInfoService.save(workInfo);
        }

        if (saw4 != null && saw4 >= 0) {
            WorkInfo workInfo = new WorkInfo();

            workInfo.setPersonWork(updatedPerson);
            workInfo.setCount(saw4);
            workInfo.setNameOfWork(SawENUM.CHIPBOARD4.getType());
            workInfo.setDate(new Date());
            workInfo.setCostOfWork(saw4 * SawENUM.CHIPBOARD4.getCostToWork());
            workInfo.setWorker(updatedPerson.getUsername());

            workInfoService.save(workInfo);
        }

        if (saw26 != null && saw26 >= 0) {
            WorkInfo workInfo = new WorkInfo();

            workInfo.setPersonWork(updatedPerson);
            workInfo.setCount(saw26);
            workInfo.setNameOfWork(SawENUM.CHIPBOARD26.getType());
            workInfo.setDate(new Date());
            workInfo.setCostOfWork(saw26 * SawENUM.CHIPBOARD26.getCostToWork());
            workInfo.setWorker(updatedPerson.getUsername());

            workInfoService.save(workInfo);
        }

        if (edging != null && edging >= 0) {
            WorkInfo workInfo = new WorkInfo();

            workInfo.setPersonWork(updatedPerson);
            workInfo.setCount(edging);
            workInfo.setNameOfWork(EdgingENUM.EDGING16.getType());
            workInfo.setDate(new Date());
            workInfo.setCostOfWork(edging * EdgingENUM.EDGING16.getCostToWork());
            workInfo.setWorker(updatedPerson.getUsername());

            workInfoService.save(workInfo);
        }

        if (newCityDelivery != null && newCityDelivery >= 0) {
            WorkInfo workInfo = new WorkInfo();

            workInfo.setPersonWork(updatedPerson);
            workInfo.setCount(newCityDelivery);
            workInfo.setNameOfWork(DeliveryENUM.NEWCITY.getDistrict());
            workInfo.setDate(new Date());
            workInfo.setCostOfWork(newCityDelivery * DeliveryENUM.NEWCITY.getCostToWork());
            workInfo.setWorker(updatedPerson.getUsername());

            workInfoService.save(workInfo);
        }

        if (oldCityDelivery != null && oldCityDelivery >= 0) {
            WorkInfo workInfo = new WorkInfo();

            workInfo.setPersonWork(updatedPerson);
            workInfo.setCount(oldCityDelivery);
            workInfo.setNameOfWork(DeliveryENUM.OLDCITY.getDistrict());
            workInfo.setDate(new Date());
            workInfo.setCostOfWork(oldCityDelivery * DeliveryENUM.OLDCITY.getCostToWork());
            workInfo.setWorker(updatedPerson.getUsername());

            workInfoService.save(workInfo);
        }

        if (komsaDelivery != null && komsaDelivery >= 0) {
            WorkInfo workInfo = new WorkInfo();

            workInfo.setPersonWork(updatedPerson);
            workInfo.setCount(komsaDelivery);
            workInfo.setNameOfWork(DeliveryENUM.KOMSOMOLSKIY.getDistrict());
            workInfo.setDate(new Date());
            workInfo.setCostOfWork(komsaDelivery * DeliveryENUM.KOMSOMOLSKIY.getCostToWork());
            workInfo.setWorker(updatedPerson.getUsername());

            workInfoService.save(workInfo);
        }

        if (samaraDelivery != null && samaraDelivery >= 0) {
            WorkInfo workInfo = new WorkInfo();

            workInfo.setPersonWork(updatedPerson);
            workInfo.setCount(samaraDelivery);
            workInfo.setNameOfWork(DeliveryENUM.SAMARA.getDistrict());
            workInfo.setDate(new Date());
            workInfo.setCostOfWork(samaraDelivery * DeliveryENUM.SAMARA.getCostToWork());
            workInfo.setWorker(updatedPerson.getUsername());

            workInfoService.save(workInfo);
        }

        if (otherDeliveryString != null) {
            List<Delivery> otherDeliveryList = TextParser.parseDeliveries(otherDeliveryString);
            if (otherDeliveryList.size() > 0) {
                HashMap<String, Integer> map = new HashMap<>();

                for (Delivery delivery : otherDeliveryList) {
                    // Если такой район уже был
                    if (map.containsKey(delivery.getDistrict())) {
                        map.put(delivery.getDistrict(), map.get(delivery.getDistrict()) + 1);
                    }
                    else {
                        map.put(delivery.getDistrict(), 1);
                    }
                }

                for (String district : map.keySet()) {
                    WorkInfo workInfo = new WorkInfo();

                    workInfo.setPersonWork(updatedPerson);
                    workInfo.setCount(map.get(district));
                    workInfo.setNameOfWork("Доставка - " + district);
                    workInfo.setDate(new Date());
                    workInfo.setCostOfWork(200 * workInfo.getCount());  //TODO сумму за каждый район нужно узнать
                    workInfo.setWorker(updatedPerson.getUsername());

                    workInfoService.save(workInfo);
                }
            }
        }

        return modelAndView;
    }

    public Person getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) auth.getPrincipal();

        Person currentPerson = personDetails.getPerson();
        return currentPerson;
    }

    public PersonDto getCurrentUserDto() {
        Person currentPerson = getCurrentUser();

        return modelMapper.map(currentPerson, PersonDto.class);
    }



    public List<PersonDto> getWorkersDto() {
        List<Person> people = peopleService.findAll();

        List<PersonDto> personDtoList = new ArrayList<>();

        // Тут должны отображаться только работники цеха
        for (Person person : people) {
            if (person.isWorker() == true) {
                personDtoList.add(modelMapper.map(person, PersonDto.class));
            }
        }

        return personDtoList;
    }

    public List<Product> parseStandartPositions(String result) {
        // Проверка на null
        if (result == null || result.equals("")) {
            List<Product> completedWorks = new ArrayList<>();
            return completedWorks;
        }

        // Сюда будем помещать всю работу по отдельности
        List<Product> products = new ArrayList<>();

        //разбиваем всю сделанную работу по отдельности через запятую
        String[] allWork = result.split(", ");

        for (String work : allWork) {


            work = work.trim(); // убрать лишние пробелы
            String[] line = work.split(" ");

            if (line.length != 2 || !TextParser.hasOnlyNumbers(line[1])) {
                return null;    //TODO exception
            }

            String positionName = line[0].toUpperCase();
            String countStr = line[1];
            int count = Integer.parseInt(countStr);

            // Пытаемся найти позицию по названию
            Optional<Product> optionalProduct = productService.findByName(positionName);

            // Если такой позиции нет в БД, идем дальше
            if (optionalProduct.isEmpty()) {
                continue;
            }
            else {
                Product product = optionalProduct.get();

                for (int i = 0; i < count; i++) {
                    products.add(product);
                }
            }


        }
        return products;
    }


    public static void main(String[] args) throws IncorrectNumberOfWordsException {
        String result = "a10 1 d, t12 4, t10 1";


    }

    public PersonDto getPersonDtoByUsername(String username) {
        Optional<Person> person = peopleService.findByUsername(username);

        if (person.isEmpty()) { // Если не нашли в БД
            return null;
        }

        Person foundPerson = person.get();
        PersonDto foundPersonDto = modelMapper.map(foundPerson, PersonDto.class);

        return foundPersonDto;
    }

    @GetMapping("/people-month-salary")
    public ModelAndView monthlySalaryPage() {
        ModelAndView modelAndView = new ModelAndView("/salary/monthly_salary");

        List<Person> people = peopleService.findByIsWorkerTrue();
        List<PersonDto> peopleDto = new ArrayList<>();

        for (Person person : people) {
            peopleDto.add(modelMapper.map(person, PersonDto.class));
        }

        modelAndView.addObject("peopleDto", peopleDto);
        modelAndView.addObject("personDto", getCurrentUserDto());
        return modelAndView;

    }

    @GetMapping("/people-month-salary/worker")
    public ModelAndView monthlySalaryWorkerPage(@RequestParam(name = "user", required = true) String username) {
        ModelAndView modelAndView = new ModelAndView("/salary/monthly_person_salary");

        Optional<Person> optionalPerson = peopleService.findByUsername(username);

        Person person = optionalPerson.get();

        if (person == null) {
            return new ModelAndView("/salary/monthly_salary");
        }

        PersonDto personDto = modelMapper.map(person, PersonDto.class);
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH) + 1;  // добавляем 1, так как нумерация месяцев в Calendar начинается с 0
        int year = calendar.get(Calendar.YEAR);

        System.out.println(year);

        List<WorkInfo> workInfoList = workInfoService.findWorkInfoByDateAndWorker(month, year, personDto.getUsername());
        Integer monthSalary = calculateMonthSalary(workInfoList);
        SalaryCalculating salaryCalculating = new SalaryCalculating(parseDaySalary(workInfoList));

        for (WorkInfo w : workInfoList) {
            System.out.println(w.getCostOfWork());
        }

        modelAndView.addObject("monthDays", parseMonthDays(workInfoList));
        modelAndView.addObject("workInfoList", workInfoList);
        modelAndView.addObject("personDto", getCurrentUserDto());
        modelAndView.addObject("currentPerson", person);
        modelAndView.addObject("daysSalary", parseDaySalary(workInfoList));
        modelAndView.addObject("monthSalary", monthSalary);
        modelAndView.addObject("salaryCalculating", salaryCalculating);

        return modelAndView;

    }

    @GetMapping("/people-month-salary/previous-month/worker")
    public ModelAndView monthlySalaryWorkerPageForThePreviousMonth(@RequestParam(name = "user", required = true) String username) {
        ModelAndView modelAndView = new ModelAndView("/salary/previous_monthly_person_salary");

        Optional<Person> optionalPerson = peopleService.findByUsername(username);

        Person person = optionalPerson.get();

        if (person == null) {
            return new ModelAndView("/salary/monthly_salary");
        }

        PersonDto personDto = modelMapper.map(person, PersonDto.class);
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH);  // получим настоящий месяц
        int year = calendar.get(Calendar.YEAR);

        // получаем предыдущий месяц, если настоящий - январь
        if (month == 0) {
            month = 12;
            year = year - 1;
        }


        System.out.println(year);

        List<WorkInfo> workInfoList = workInfoService.findWorkInfoByDateAndWorker(month, year, personDto.getUsername());
        Integer monthSalary = calculateMonthSalary(workInfoList);
        SalaryCalculating salaryCalculating = new SalaryCalculating(parseDaySalary(workInfoList));

        for (WorkInfo w : workInfoList) {
            System.out.println(w.getCostOfWork());
        }
        modelAndView.addObject("monthDays", parseMonthDays(workInfoList));
        modelAndView.addObject("workInfoList", workInfoList);
        modelAndView.addObject("personDto", getCurrentUserDto());
        modelAndView.addObject("currentPerson", person);
        modelAndView.addObject("daysSalary", parseDaySalary(workInfoList));
        modelAndView.addObject("monthSalary", monthSalary);
        modelAndView.addObject("salaryCalculating", salaryCalculating);

        return modelAndView;

    }

    public Set<Date> parseMonthDays(List<WorkInfo> workInfoList) {
        Set<Date> days = new HashSet<>();

        for (WorkInfo workInfo : workInfoList) {
            if (!days.contains(workInfo.getDate())) {
                days.add(workInfo.getDate());
            }
        }

        return days;
    }

    public HashMap<Date, Integer> parseDaySalary(List<WorkInfo> workInfoList) {
        HashMap<Date, Integer> workMap = new HashMap<>();

        for (WorkInfo workInfo : workInfoList) {
            if (!workMap.containsKey(workInfo.getDate())) {
                Integer sum = workInfo.getCostOfWork();

                workMap.put(workInfo.getDate(), sum);
            }
            else {
                Integer oldCost =  workMap.get(workInfo.getDate());
                Integer newCost = oldCost + workInfo.getCostOfWork();

                workMap.put(workInfo.getDate(), newCost);
            }
        }

        return workMap;
    }


    public Integer calculateMonthSalary(List<WorkInfo> workInfoList) {
        int sum = 0;
        for (WorkInfo workInfo : workInfoList) {
            sum += workInfo.getCostOfWork();
        }

        return sum;
    }


}
