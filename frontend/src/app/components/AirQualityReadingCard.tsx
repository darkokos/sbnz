import { Dispatch, SetStateAction, useState } from "react";
import HomeStateCardTemplate from "./HomeStateCardTemplate";
import { Recommendations } from "../models/recommendations";
import { Box, Slider, Stack, Typography } from "@mui/material";
import { useSnackbar } from "notistack";

export default function AirQualityReadingCard({
  onResultHook,
}: {
  onResultHook: Dispatch<SetStateAction<Recommendations>>;
}) {
  const { enqueueSnackbar } = useSnackbar();

  type AirQualityReadingState = {
    humidity: number;
    airQuality: number;
  };

  const [state, setState] = useState<AirQualityReadingState>({
    humidity: 0,
    airQuality: 0,
  });

  const onSubmit = () => {
    fetch(
      `${process.env.NEXT_PUBLIC_SERVER_URL ?? ""}/reading/air-quality-reading`,
      {
        method: "PUT",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(state),
      },
    )
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
    <HomeStateCardTemplate title="Air Quality Reading" onSubmit={onSubmit}>
      <Stack>
        <Typography>Humidity [%]:</Typography>
        <Box paddingX={2}>
          <Slider
            value={state.humidity}
            onChange={(_, value) => setState({ ...state, ["humidity"]: value })}
            min={0}
            max={100}
            valueLabelDisplay="auto"
          />
        </Box>
      </Stack>
      <Stack>
        <Typography>Air Quality [%]:</Typography>
        <Box paddingX={2}>
          <Slider
            value={state.airQuality}
            onChange={(_, value) =>
              setState({ ...state, ["airQuality"]: value })
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
