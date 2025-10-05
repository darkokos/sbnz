"use client";

import { Divider, Grid, Typography } from "@mui/material";
import Masonry from "@mui/lab/Masonry";
import PageTemplate from "./components/PageTemplate";
import AirConditionerCard from "./components/AirConditionerCard";
import { useState } from "react";
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

export default function Home() {
  const [recommendations, setRecommendations] = useState<Recommendations>({});

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
          </Masonry>
        </Grid>
        <Grid container size={1} justifyContent={"center"}>
          <Divider orientation="vertical" />
        </Grid>
        <Grid size={4}>
          <Typography variant="h4">Recommendations</Typography>
        </Grid>
      </Grid>
    </PageTemplate>
  );
}
