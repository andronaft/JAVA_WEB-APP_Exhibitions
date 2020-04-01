package com.snezhko.controller;

import com.snezhko.entity.ExhibitEntity;
import com.snezhko.entity.HallEntity;
import com.snezhko.entity.TransactionEntity;
import com.snezhko.entity.UserEntity;
import com.snezhko.service.UserService;
import com.snezhko.service.impl.ExhibitServiceImpl;
import com.snezhko.service.impl.HallServiceImpl;
import com.snezhko.service.impl.TransactionServiceImpl;
import com.snezhko.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;


@RestController
public class Controller {

    private final ExhibitServiceImpl exhibitService;
    private final HallServiceImpl hallService;
    private final TransactionServiceImpl transactionService;
    private final UserServiceImpl userService;

    @Autowired
    public Controller(@Qualifier("ExhibitServiceImpl") ExhibitServiceImpl exhibitService, @Qualifier("HallServiceImpl") HallServiceImpl hallService,@Qualifier("TransactionServiceImpl") TransactionServiceImpl transactionService, @Qualifier("UserServiceImpl") UserServiceImpl userService  ){
        this.exhibitService = exhibitService;
        this.hallService = hallService;
        this.transactionService = transactionService;
        this.userService = userService;
    }

    @RequestMapping("/")
    String hello() {
        return "Hello World!";
    }

    @PostMapping("/login")
    String login(@RequestBody UserEntity userEntity) {
        return userService.login(userEntity).toString();
    }

    @PostMapping("/registration")
    void registration(@RequestBody UserEntity userEntity) {
        userService.registration(userEntity);
    }

    @PostMapping("/getAllUsers")
    String getAllUsers(@RequestBody UserEntity admin)
    {
        return userService.getAll(admin).toString();
    }

    @PostMapping("/getUserById")
    String getUserById(@RequestBody UserEntity userEntity)
    {
        return userService.getById(userEntity).toString();
    }

    @PostMapping("/goodTransaction")
    void goodTransaction(@RequestBody TransactionEntity transactionEntity)
    {
        transactionService.save(transactionEntity);
    }

    @RequestMapping("/getTransactionByUserId")
    String getTrByUId(@RequestParam int userId)
    {
        return transactionService.getByUserId(userId).toString();
    }

    @PostMapping("/AllTransaction")
    String AllTransaction(@RequestBody UserEntity admin)
    {
        if(userService.isAdmin(admin)){
            return transactionService.getAll().toString();
        }
        return null;
    }

    @RequestMapping("/getAllHall")
    String getAllHall()
    {
        return hallService.getAll().toString();
    }

    @PostMapping("/changeHallTheme")
    void changeHallTheme(@RequestBody HallEntity hallEntity,@RequestBody UserEntity admin)
    {
        if(userService.isAdmin(admin)){
            hallService.changeTheme(hallEntity);
        }
    }

    @PostMapping("/createHall")
    void createHall(@RequestBody HallEntity hallEntity,@RequestBody UserEntity admin)
    {
        if(userService.isAdmin(admin)){
            hallService.create(hallEntity);
        }
    }

    @RequestMapping("/getHallById")
    String getHallById(@RequestParam int id)
    {
        return hallService.getById(id).toString();
    }

    @RequestMapping("/geExhibitionById")
    String getExhibitionById(@RequestParam int id)
    {
        return exhibitService.getById(id).toString();
    }

    @RequestMapping("/getAllExhibition")
    String getAllExhibition()
    {
        return exhibitService.getAll().toString();
    }

    @PostMapping("/changeExhibitionHall")
    void changeExhibitionHall(@RequestBody ExhibitEntity exhibitEntity, @RequestBody UserEntity admin)
    {
        if(userService.isAdmin(admin)){
            exhibitService.changeHallId(exhibitEntity);
        }
    }

    @PostMapping("/createExhibition")
    void createExhibition(@RequestBody ExhibitEntity exhibitEntity, @RequestBody UserEntity admin)
    {
        if(userService.isAdmin(admin)){
            exhibitService.create(exhibitEntity);
        }
    }
}
