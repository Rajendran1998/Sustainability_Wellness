const express = require("express");
const app=express();

const port = process.env.PORT||80;

const randomNumber=(min,max)=>
{
    return Math.floor(Math.random()*(max-min)+min);
};

const randomTemperture = (min,max)=>
{
    let temperature = Math.random()*(max-min)+min;
    return temperature.toFixed(2);
};



app.get("/api/bp",(req,res)=>{
    res.status(200).json(
        
     randomNumber(80,120)

    );
});
app.get("/api/bt",(req,res)=>{
    res.status(200).json(
        
        randomTemperture(35.5,37.5)

    );
});
app.get("/api/r",(req,res)=>{
    res.status(200).json(
        
     randomNumber(12,20)

    );
});
app.get("/api/g",(req,res)=>{
    res.status(200).json(
        
     randomNumber(80,140)

    );
});
app.get("/api/hr",(req,res)=>{
    res.status(200).json(
        
     randomNumber(60,100)

    );
});
app.get("/api/os",(req,res)=>{
    res.status(200).json(
        
     randomNumber(75,100)

    );
});

app.listen(port,()=>console.log("server listening to the port:",port));
