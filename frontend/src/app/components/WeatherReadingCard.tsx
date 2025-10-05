import { Dispatch, SetStateAction, useState } from "react";
import { Recommendations } from "../models/recommendations";
import { useSnackbar } from "notistack";
import HomeStateCardTemplate from "./HomeStateCardTemplate";
import { Box, Slider, Stack, Typography } from "@mui/material";

export default function WeatherReadingCard({
  onResultHook,
}: {
  onResultHook: Dispatch<SetStateAction<Recommendations>>;
}) {
  const { enqueueSnackbar } = useSnackbar();

  type WeatherReadingState = {
    cloudCoverage: number;
  };

  const [state, setState] = useState<WeatherReadingState>({
    cloudCoverage: 0,
  });

  const onSubmit = async () => {
    fetch(
      `${process.env.NEXT_PUBLIC_SERVER_URL ?? ""}/reading/weather-reading`,
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
    <HomeStateCardTemplate title="Weather Reading" onSubmit={onSubmit}>
      <Stack>
        <Typography>Cloud coverage:</Typography>
        <Box paddingX={2}>
          <Slider
            value={state.cloudCoverage}
            onChange={(_, value) =>
              setState({ ...state, ["cloudCoverage"]: value })
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
