import { Dispatch, SetStateAction, useState } from "react";
import HomeStateCardTemplate from "./HomeStateCardTemplate";
import { Recommendations } from "../models/recommendations";
import { Box, Slider, Stack, TextField, Typography } from "@mui/material";
import { useSnackbar } from "notistack";

export default function SolarGeneratorCard({
  onResultHook,
}: {
  onResultHook: Dispatch<SetStateAction<Recommendations>>;
}) {
  const { enqueueSnackbar } = useSnackbar();

  type SolarGeneratorState = {
    production: string;
    currentBatteryCharge: number;
  };

  const [state, setState] = useState<SolarGeneratorState>({
    production: "",
    currentBatteryCharge: 0,
  });

  const onSubmit = () => {
    fetch(`${process.env.NEXT_PUBLIC_SERVER_URL ?? ""}/state/solar-generator`, {
      method: "PUT",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(state),
    })
      .then((response) => {
        if (response.status > 300 || response.status < 200) {
          response
            .json()
            .then((error) => enqueueSnackbar(error, { variant: "error" }));
        } else {
          response.json().then((data) => onResultHook(data));
        }
      })
      .catch((error) => enqueueSnackbar(error, { variant: "error" }));
  };

  return (
    <HomeStateCardTemplate title="Solar Generator" onSubmit={onSubmit}>
      <TextField
        label="Production [kWh]"
        value={state.production}
        onChange={(e) => setState({ ...state, ["production"]: e.target.value })}
        fullWidth
      />
      <Stack>
        <Typography marginLeft={2}>Current battery charge [%]:</Typography>
        <Box paddingX={2}>
          <Slider
            value={state.currentBatteryCharge}
            onChange={(_, value) =>
              setState({ ...state, ["currentBatteryCharge"]: value })
            }
            min={0}
            max={100}
            valueLabelDisplay="auto"
          />
        </Box>
      </Stack>
    </HomeStateCardTemplate>
  );
}
