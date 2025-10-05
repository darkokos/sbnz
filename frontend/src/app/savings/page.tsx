"use client";

import { Box, Button, Stack, TextField, Typography } from "@mui/material";
import PageTemplate from "../components/PageTemplate";
import { ChangeEvent, useState } from "react";
import { useSnackbar } from "notistack";

export default function Savings() {
  const { enqueueSnackbar } = useSnackbar();

  const [generatedEnergy, setGeneratedEnergy] = useState("0");
  const [energySaved, setEnergySaved] = useState(0);

  const handleGeneratedEnergyChanged = (
    e: ChangeEvent<HTMLInputElement | HTMLTextAreaElement>,
  ) => {
    setGeneratedEnergy(e.target.value);
  };

  const handleSubmitClicked = () => {
    fetch(
      `${process.env.NEXT_PUBLIC_SERVER_URL ?? ""}/reading/solar-generator-reading`,
      {
        method: "PUT",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({ generatedPower: generatedEnergy }),
      },
    )
      .then((response) => {
        if (response.status > 300 || response.status < 200) {
          response
            .json()
            .then((error) => enqueueSnackbar(error, { variant: "error" }));
        } else {
          response.json().then((data) => setEnergySaved(data));
        }
      })
      .catch((error) => enqueueSnackbar(error, { variant: "error" }));
  };

  return (
    <PageTemplate title="Solar Savings">
      <Stack direction="row" gap={2} alignItems="center">
        <Typography variant="h4">Latest solar reading:</Typography>
        <TextField
          label="Generated Energy [kWh]"
          value={generatedEnergy}
          onChange={handleGeneratedEnergyChanged}
        />
        <Button variant="outlined" onClick={handleSubmitClicked}>
          Submit
        </Button>
      </Stack>
      <Typography variant="h5" color="success">
        You have saved {energySaved}kWh in the last 24h.
      </Typography>
    </PageTemplate>
  );
}
