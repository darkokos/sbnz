import { Dispatch, SetStateAction, useState } from "react";
import HomeStateCardTemplate from "./HomeStateCardTemplate";
import { Recommendations } from "../models/recommendations";
import { Stack, Switch, Typography } from "@mui/material";
import { useSnackbar } from "notistack";

export default function ElectricCarChargerCard({
  onResultHook,
}: {
  onResultHook: Dispatch<SetStateAction<Recommendations>>;
}) {
  const { enqueueSnackbar } = useSnackbar();

  type ElectricCarChargerState = {
    isCharging: boolean;
  };

  const [state, setState] = useState<ElectricCarChargerState>({
    isCharging: false,
  });

  const onSubmit = () => {
    fetch(`${process.env.NEXT_PUBLIC_SERVER_URL ?? ""}/state/car-charger`, {
      method: "PUT",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(state.isCharging),
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
    <HomeStateCardTemplate title="Electric Car Charger" onSubmit={onSubmit}>
      <Stack
        direction="row"
        justifyContent="space-between"
        alignItems="center"
        paddingX={2}
      >
        <Typography>Is charging:</Typography>
        <Switch
          checked={state.isCharging}
          onChange={(e) =>
            setState({ ...state, ["isCharging"]: e.target.checked })
          }
        />
      </Stack>
    </HomeStateCardTemplate>
  );
}
