"use client";

import { Divider, Grid, Stack, Typography } from "@mui/material";
import Masonry from "@mui/lab/Masonry";
import PageTemplate from "./components/PageTemplate";
import AirConditionerCard from "./components/AirConditionerCard";
import { useEffect, useState } from "react";
import BoilerCard from "./components/BoilerCard";
import ElectricCarChargerCard from "./components/ElectricCarChargerCard";
import FloorHeaterCard from "./components/FloorHeaterCard";
import HomeCard from "./components/HomeCard";
import LightsCard from "./components/LightsCard";
import RadiatorCard from "./components/RadiatorCard";
import SolarGeneratorCard from "./components/SolarGeneratorCard";
import SpaceHeaterCard from "./components/SpaceHeaterCard";
import WashingMachineCard from "./components/WashingMachineCard";
import { Recommendations } from "./models/recommendations";
import AirPurifierCard from "./components/AirPurifierCard";
import AirQualityReadingCard from "./components/AirQualityReadingCard";
import DishWasherCard from "./components/DishWasherCard";
import DryerCard from "./components/DryerCard";
import TimeReadingCard from "./components/TimeReadingCard";
import { useSnackbar } from "notistack";
import WeatherReadingCard from "./components/WeatherReadingCard";

export default function Home() {
  const { enqueueSnackbar } = useSnackbar();

  const [recommendations, setRecommendations] = useState<Recommendations>({
    carCharging: false,
    powerSource: "GRID",
    acOn: false,
    spaceHeaterOn: false,
    radiatorOn: false,
    floorHeatingOn: false,
    washingMachineOn: false,
    lightBrightness: 0,
    boilerOn: false,
    dryerOn: false,
    airPurifierOn: false,
    dishWasherOn: false,
  });

  useEffect(() => {
    fetch(`${process.env.NEXT_PUBLIC_SERVER_URL ?? ""}/state`, {
      method: "GET",
      headers: {
        "Content-Type": "application/json",
      },
    })
      .then((response) =>
        response.json().then((data) => setRecommendations(data)),
      )
      .catch((error) => enqueueSnackbar(error, { variant: "error" }));
  }, []);

  return (
    <PageTemplate title="Home State">
      <Grid container>
        <Grid size={7}>
          <Masonry columns={2} spacing={2}>
            <AirConditionerCard onResultHook={setRecommendations} />
            <AirPurifierCard onResultHook={setRecommendations} />
            <AirQualityReadingCard onResultHook={setRecommendations} />
            <BoilerCard onResultHook={setRecommendations} />
            <DishWasherCard onResultHook={setRecommendations} />
            <DryerCard onResultHook={setRecommendations} />
            <ElectricCarChargerCard onResultHook={setRecommendations} />
            <FloorHeaterCard onResultHook={setRecommendations} />
            <HomeCard onResultHook={setRecommendations} />
            <LightsCard onResultHook={setRecommendations} />
            <RadiatorCard onResultHook={setRecommendations} />
            <SolarGeneratorCard onResultHook={setRecommendations} />
            <SpaceHeaterCard onResultHook={setRecommendations} />
            <TimeReadingCard onResultHook={setRecommendations} />
            <WashingMachineCard onResultHook={setRecommendations} />
            <WeatherReadingCard onResultHook={setRecommendations} />
          </Masonry>
        </Grid>
        <Grid container size={1} justifyContent={"center"}>
          <Divider orientation="vertical" />
        </Grid>
        <Grid size={4}>
          <Stack>
            <Typography variant="h4">Recommendations</Typography>
            <Typography>Power source: {recommendations.powerSource}</Typography>
            <Typography>
              Lights brightness : {recommendations.lightBrightness}%
            </Typography>
            <Typography>
              Should car be charging:{" "}
              {recommendations.carCharging ? "Yes" : "No"}
            </Typography>
            <Typography>
              Should AC be on: {recommendations.acOn ? "Yes" : "No"}
            </Typography>
            <Typography>
              Should space heater be on:{" "}
              {recommendations.spaceHeaterOn ? "Yes" : "No"}
            </Typography>
            <Typography>
              Should radiator be on: {recommendations.radiatorOn ? "Yes" : "No"}
            </Typography>
            <Typography>
              Should floor heating be on:{" "}
              {recommendations.floorHeatingOn ? "Yes" : "No"}
            </Typography>
            <Typography>
              Should washing machine be on:{" "}
              {recommendations.washingMachineOn ? "Yes" : "No"}
            </Typography>
            <Typography>
              Should boiler be on: {recommendations.boilerOn ? "Yes" : "No"}
            </Typography>
            <Typography>
              Should dryer be on: {recommendations.dryerOn ? "Yes" : "No"}
            </Typography>
            <Typography>
              Should air purifier be on:{" "}
              {recommendations.airPurifierOn ? "Yes" : "No"}
            </Typography>
            <Typography>
              Should dish washer be on:{" "}
              {recommendations.dishWasherOn ? "Yes" : "No"}
            </Typography>
          </Stack>
        </Grid>
      </Grid>
    </PageTemplate>
  );
}
