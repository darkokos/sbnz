import { Dispatch, SetStateAction, useState } from "react";
import HomeStateCardTemplate from "./HomeStateCardTemplate";
import { Recommendations } from "../models/recommendations";
import { useSnackbar } from "notistack";
import {
  FormControl,
  InputLabel,
  MenuItem,
  Select,
  TextField,
} from "@mui/material";

export default function HomeCard({
  onResultHook,
}: {
  onResultHook: Dispatch<SetStateAction<Recommendations>>;
}) {
  const { enqueueSnackbar } = useSnackbar();

  type HomeState = {
    powerSource: "GRID" | "RESERVES";
    currentConsumption: string;
    numberOfPresentResidents: string;
    consumptionProfile: "NIGHTLY" | "BALANCED" | "ECO" | "COMING_HOME";
    desiredTemp: string;
  };

  const [state, setState] = useState<HomeState>({
    powerSource: "GRID",
    currentConsumption: "",
    numberOfPresentResidents: "",
    consumptionProfile: "ECO",
    desiredTemp: "",
  });

  const onSubmit = () => {
    fetch(`${process.env.NEXT_PUBLIC_SERVER_URL ?? ""}/state/home`, {
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
    <HomeStateCardTemplate title="Home" onSubmit={onSubmit}>
      <FormControl>
        <InputLabel id="power-source-label">Power Source</InputLabel>
        <Select
          labelId="power-source-label"
          label="Power Source"
          defaultValue="Grid"
          value={state.powerSource}
          onChange={(e) =>
            setState({
              ...state,
              ["powerSource"]: e.target.value as "GRID" | "RESERVES",
            })
          }
          fullWidth
        >
          <MenuItem value="GRID">Grid</MenuItem>
          <MenuItem value="RESERVES">Reserves</MenuItem>
        </Select>
      </FormControl>
      <TextField
        label="Current Consumption"
        value={state.currentConsumption}
        onChange={(e) =>
          setState({ ...state, ["currentConsumption"]: e.target.value })
        }
        fullWidth
      />
      <TextField
        label="Number of Present Residents"
        type="number"
        slotProps={{ inputLabel: { shrink: true } }}
        value={state.numberOfPresentResidents}
        onChange={(e) =>
          setState({ ...state, ["numberOfPresentResidents"]: e.target.value })
        }
        fullWidth
      />
      <FormControl>
        <InputLabel id="consumption-profile-label">
          Consumption Profile
        </InputLabel>
        <Select
          labelId="consumption-profile-label"
          label="Consumption Profile"
          defaultValue="ECO"
          value={state.consumptionProfile}
          onChange={(e) =>
            setState({
              ...state,
              ["consumptionProfile"]: e.target.value as
                | "NIGHTLY"
                | "BALANCED"
                | "ECO"
                | "COMING_HOME",
            })
          }
          fullWidth
        >
          <MenuItem value="NIGHTLY">Nightly</MenuItem>
          <MenuItem value="BALANCED">Balanced</MenuItem>
          <MenuItem value="ECO">Eco</MenuItem>
          <MenuItem value="COMING_HOME">Coming Home</MenuItem>
        </Select>
      </FormControl>
      <TextField
        label="Desired Temperature"
        value={state.desiredTemp}
        onChange={(e) =>
          setState({ ...state, ["desiredTemp"]: e.target.value })
        }
        fullWidth
      />
    </HomeStateCardTemplate>
  );
}
