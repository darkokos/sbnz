import { Dispatch, SetStateAction, useState } from "react";
import HomeStateCardTemplate from "./HomeStateCardTemplate";
import { Recommendations } from "../models/recommendations";
import { Stack, Switch, Typography } from "@mui/material";
import { useSnackbar } from "notistack";

export default function AirPurifierCard({
  onResultHook,
}: {
  onResultHook: Dispatch<SetStateAction<Recommendations>>;
}) {
  const { enqueueSnackbar } = useSnackbar();

  type AirPurifierState = {
    isOn: boolean;
  };

  const [state, setState] = useState<AirPurifierState>({
    isOn: false,
  });

  const onSubmit = () => {
    fetch(`${process.env.NEXT_PUBLIC_SERVER_URL ?? ""}/state/air-purifier`, {
      method: "PUT",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(state.isOn),
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
    <HomeStateCardTemplate title="Air Purifier" onSubmit={onSubmit}>
      <Stack
        direction="row"
        justifyContent="space-between"
        alignItems="center"
        paddingX={2}
      >
        <Typography>Is on:</Typography>
        <Switch
          checked={state.isOn}
          onChange={(e) => setState({ ...state, ["isOn"]: e.target.checked })}
        />
      </Stack>
    </HomeStateCardTemplate>
  );
}
